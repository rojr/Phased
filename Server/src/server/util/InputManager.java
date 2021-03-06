package server.util;

import server.Server;
import server.commands.Command;
import server.commands.PlayerCommand;
import server.helpers.StringHelper;
import server.model.items.ItemList;
import server.model.players.Client;
import server.model.players.PlayerHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class InputManager implements Runnable {

    private ServerSocket server;
    private ArrayList<Command> commands;

    public InputManager() {
        try {
            server = new ServerSocket(4412, 0);
            System.out.println("Command server loaded and running on port 4412");
        } catch (UnknownHostException e) {
            System.out.println("Could not create a new server :(");
        } catch (IOException e) {
            System.out.println("IO Exception when creating the server");
        }

        commands = new ArrayList<>();

        commands.add(new Command("uptime", (Command c) -> c.output(Server.getUptime())));
        commands.add(new Command("players", (Command c) -> c.output(StringHelper.combine(PlayerHandler.playersCurrentlyOn, ","))));
        commands.add(new PlayerCommand("player", (PlayerCommand c) -> {
            c.getArgs()
                    .addArgument((String variable) -> c.setPlayer((Client) PlayerHandler.getPlayerFromName(variable)), "p", "-player")
                    .addArgument((String s) -> c.getPlayer().logout(), "k", "-kick")
                    .addArgument((String s) -> {
                        ArrayList<String> x = StringHelper.removeEmptyArrayEntries(s.split(" "));
                        c.getPlayer().getItems().addItem(Integer.parseInt(x.get(0)), Integer.parseInt(x.get(1)));
                    }, "g", "-give")
                    .addArgument((String s) -> c.getPlayer().getItems().deleteAllItems(), "-delete-invent")
                    .addArgument((String s) -> c.getPlayer().getPlayerAssistant().bankAll(), "-bank-invent");
        }));

        commands.add(new PlayerCommand("item", (PlayerCommand c) -> {
            c.getArgs()
                    .addArgument((String s) -> {
                        ArrayList<String> x = StringHelper.explodeOnSpaceRemoveEmpty(s);
                        ItemList i = Server.itemHandler.ItemList[Integer.parseInt(x.get(0))];
                        i.Bonuses[Integer.parseInt(x.get(1))] = Integer.parseInt(x.get(2));
                    }, "c", "-change")
                    .addArgument((String s) -> {
                        for (String p : PlayerHandler.playersCurrentlyOn) {
                            Server.itemHandler.reloadItems((Client) PlayerHandler.getPlayerFromName(p));
                        }
                    }, "-reload");
        }));

        commands.add(new Command("npc", (Command c) -> {
            c.getArgs()
                    .addArgument((String s) -> Server.npcDrops.reloadNpcDrops(), "-reload-drops")
                    .addArgument((String s) -> Server.npcHandler.loadNPCList("a"), "-reload-npcs");
        }));

        commands.add(new Command("debug", (Command c) -> {
            System.out.println("lol");
        }));
    }

    public String handleInput(String line) {
        for (Command c : this.commands) {
            if (line.startsWith(c.getActivation())) {
                return c.runCommand(line.replace(c.getActivation() + " ", ""));
            }
        }
        return "";
    }

    public ArrayList<Command> getCommands() {
        return this.commands;
    }

    public void run() {
        Socket socket;
        BufferedReader is;
        PrintWriter os;

        while (true) {
            try {
                socket = server.accept();
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                os = new PrintWriter(socket.getOutputStream(), true);

                String responseLine;
                while ((responseLine = is.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    os.println(handleInput(responseLine));
                    break;
                }

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
