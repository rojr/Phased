package server.model.players.skills;

import server.Config;
import server.model.players.Client;
import server.util.Misc;

public class Woodcutting extends Skill {

    private final int VALID_AXE[] = {1351, 1349, 1353, 1361, 1355, 1357, 1359, 6739};
    private final int[] AXE_REQS = {1, 1, 6, 6, 21, 31, 41, 61};
    private final int EMOTE = 875;
    private int logType;
    private int exp;

    public Woodcutting(Client c) {
        super(c);
    }

    public void startWoodcutting(int logType, int levelReq, int exp) {
        Client c = getClient();

        if (goodAxe() > 0) {
            c.turnPlayerTo(c.objectX, c.objectY);
            if (c.playerLevel[c.playerWoodcutting] >= levelReq) {
                this.logType = logType;
                this.exp = exp;
                c.wcTimer = getWcTimer();
                c.startAnimation(EMOTE);
            } else {
                c.getPlayerAssistant().resetVariables();
                c.startAnimation(65535);
                c.sendMessage("You need a woodcutting level of " + levelReq + " to cut this tree.");
            }
        } else {
            c.startAnimation(65535);
            c.sendMessage("You need an axe to cut this tree.");
            c.getPlayerAssistant().resetVariables();
        }
    }

    public void cutWood() {
        Client c = getClient();

        if (c.getItems().addItem(logType, 1)) {
            c.startAnimation(EMOTE);
            c.sendMessage("You get some logs.");
            c.getPlayerAssistant().addSkillXP(exp * Config.WOODCUTTING_EXPERIENCE, c.playerWoodcutting);
            c.getPlayerAssistant().refreshSkill(c.playerWoodcutting);
            c.wcTimer = getWcTimer();
        } else {
            c.getPlayerAssistant().resetVariables();
        }
    }

    public int goodAxe() {
        Client c = getClient();

        for (int j = VALID_AXE.length - 1; j >= 0; j--) {
            if (c.playerEquipment[c.playerWeapon] == VALID_AXE[j]) {
                if (c.playerLevel[c.playerWoodcutting] >= AXE_REQS[j])
                    return VALID_AXE[j];
            }
        }
        for (int i = 0; i < c.playerItems.length; i++) {
            for (int j = VALID_AXE.length - 1; j >= 0; j--) {
                if (c.playerItems[i] == VALID_AXE[j] + 1) {
                    if (c.playerLevel[c.playerWoodcutting] >= AXE_REQS[j])
                        return VALID_AXE[j];
                }
            }
        }
        return -1;
    }

    public int getWcTimer() {
        return Misc.random(5);
    }
}