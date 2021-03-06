package server;

import org.Vote.MainLoader;
import org.apache.mina.common.IoAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;
import server.event.EventManager;
import server.model.minigames.*;
import server.model.npcs.NPCDrops;
import server.model.npcs.NPCHandler;
import server.model.players.Client;
import server.model.players.Player;
import server.model.players.PlayerHandler;
import server.model.players.PlayerSave;
import server.net.ConnectionHandler;
import server.net.ConnectionThrottleFilter;
import server.util.*;
import server.util.log.Logger;
import server.world.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.DecimalFormat;

/**
 * Server.java
 *
 * @author Sanity
 * @author Graham
 * @author Blake
 * @author Ryan Lmctruck30
 */

public class Server {

    public static boolean sleeping;
    public static int cycleRate;
    public static MadTurnipConnection md;
    public static boolean UpdateServer = false;
    public static long lastMassSave = System.currentTimeMillis();
    public static boolean shutdownServer = false;
    public static boolean shutdownClientHandler;
    public static int serverlistenerPort;
    public static ItemHandler itemHandler = new ItemHandler();
    public static PlayerHandler playerHandler = new PlayerHandler();
    public static ControlPanel panel = new ControlPanel(false); // false if you want it off
    public static NPCHandler npcHandler = new NPCHandler();
    public static ShopHandler shopHandler = new ShopHandler();
    public static ObjectHandler objectHandler = new ObjectHandler();
    public static ObjectManager objectManager = new ObjectManager();
    public static CastleWars castleWars = new CastleWars();
    public static FightPits fightPits = new FightPits();
    public static PestControl pestControl = new PestControl();
    public static MainLoader vote;// GTL Vote loader. Used later. ~SK8R.
    public static int days, hours, minutes, seconds;
    public static NPCDrops npcDrops = new NPCDrops();
    public static ClanChatHandler clanChat = new ClanChatHandler();
    public static FightCaves fightCaves = new FightCaves();
    public static RFD rfd = new RFD();
    //public static WorldMap worldMap = new WorldMap();
    public static long[] TIMES = new long[5];
    private static long startTime = System.currentTimeMillis();
    private static IoAcceptor acceptor;
    private static ConnectionHandler connectionHandler;
    private static ConnectionThrottleFilter throttleFilter;
    private static SimpleTimer engineTimer, debugTimer;
    private static long cycleTime, cycles, totalCycleTime, sleepTime;
    private static DecimalFormat debugPercentFormat;
    private static WarriorsGuild warriorsGuild = new WarriorsGuild();

    static {
        if (!Config.SERVER_DEBUG) {
            serverlistenerPort = 43594;
        } else {
            serverlistenerPort = 43594;
        }
        cycleRate = 474;
        shutdownServer = false;
        engineTimer = new SimpleTimer();
        debugTimer = new SimpleTimer();
        sleepTime = 0;
        debugPercentFormat = new DecimalFormat("0.0#%");
    }

    public static WarriorsGuild getWarriorsGuild() {
        return warriorsGuild;
    }

    public static void shutdown() {
        shutdownServer = true;
        System.exit(0);
    }

    public static void main(java.lang.String args[]) throws NullPointerException, IOException {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                for (Player p : PlayerHandler.players) {
                    if (p == null)
                        continue;
                    System.out.println("Saving all players...");
                    PlayerSave.saveGame((Client) p);
                }
            }
        });
        try {
            WalkingHandler.getSingleton().initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.setOut(new Logger(System.out));
        System.setErr(new Logger(System.err));

        acceptor = new SocketAcceptor();
        connectionHandler = new ConnectionHandler();

        SocketAcceptorConfig sac = new SocketAcceptorConfig();
        sac.getSessionConfig().setTcpNoDelay(false);
        sac.setReuseAddress(true);
        sac.setBacklog(100);

        throttleFilter = new ConnectionThrottleFilter(Config.CONNECTION_DELAY);
        sac.getFilterChain().addFirst("throttleFilter", throttleFilter);
        acceptor.bind(new InetSocketAddress(serverlistenerPort), connectionHandler, sac);

        EventManager.initialize();
        Connection.initialize();
        try {
            WalkingHandler.getSingleton().initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /**
         * Server Successfully Loaded
         */
        System.out.println("Server online on port: " + serverlistenerPort);

        new Thread(new InputManager()).start();

        /**
         * Main Server Tick
         */
        try {
            while (!Server.shutdownServer) {
                if (sleepTime > 0)
                    Thread.sleep(sleepTime);
                PublicEvent.process();
                engineTimer.reset();
                itemHandler.process();
                playerHandler.process();
                npcHandler.process();
                shopHandler.process();
                objectManager.process();
                fightPits.process();
                pestControl.process();
                cycleTime = engineTimer.elapsed();
                if (cycleTime < 575)
                    sleepTime = cycleRate - cycleTime;
                else
                    sleepTime = 0;
                totalCycleTime += cycleTime;
                cycles++;
                if (Config.SERVER_DEBUG)
                    seconds++;
                if (seconds == 120) {
                    minutes++;
                    seconds = 0;
                }
                if (minutes == 60) {
                    hours++;
                    minutes = 0;
                }
                if (hours == 24) {
                    days++;
                    hours = 0;
                }

                if (hours == 2 && minutes == 0 && seconds == 20) {
                    PlayerHandler.updateSeconds = 60;
                    PlayerHandler.updateAnnounced = false;
                    PlayerHandler.updateRunning = true;
                    PlayerHandler.updateStartTime = System.currentTimeMillis();
                }
                if (UpdateServer) {
                    if (System.currentTimeMillis() - PlayerHandler.updateStartTime > 15000) {
                        System.gc();
                        Server.shutdown();
                    }
                }

                if (System.currentTimeMillis() - lastMassSave > 72000000) {
                    for (Player p : PlayerHandler.players) {
                        if (p == null)
                            continue;
                        PlayerSave.saveGame((Client) p);
                        System.out.println("Saved game for " + p.playerName + ".");
                        lastMassSave = System.currentTimeMillis();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            for (Player p : PlayerHandler.players) {
                if (p == null)
                    continue;
                PlayerSave.saveGame((Client) p);
                System.out.println("Saved game for " + p.playerName + ".");
            }
        }
        acceptor = null;
        connectionHandler = null;
        System.exit(0);
    }

    public static String getUptime() {
        long diff = System.currentTimeMillis() - Server.startTime;
        return Time.unixToString(diff);
    }

    public static long getSleepTimer() {
        return sleepTime;
    }
}
