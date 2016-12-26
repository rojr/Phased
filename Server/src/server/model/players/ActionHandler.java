package server.model.players;

import server.Config;
import server.Server;
import server.model.objects.Object;
import server.util.Misc;
import server.util.ScriptManager;

public class ActionHandler {
    int[] donatorRitem = {};
    int[] PvpItems = {14876, 14877, 14878, 14879, 14880, 14881, 14882, 14883, 14884, 14885, 14886, 14888, 14889, 14890, 14891, 14892};
    int[] PvpPrices = {10000000, 1000000, 500000, 35000, 800000, 150000, 280000, 840000, 150000, 125000, 80000, 5000000, 240000, 108700, 200000, 284000};
    private Client c;

    public ActionHandler(Client Client) {
        this.c = Client;
    }

    public int donatorRitem() {
        return donatorRitem[(int) (Math.random() * donatorRitem.length)];
    }

    public void wildyditch() {
        {
            if (c.absY <= c.objectY) {

                c.startAnimation(6132);
                c.getPlayerAssistant().walkTo(0, +3);
            } else if (c.objectY < c.absY) {
                c.startAnimation(6132);
                c.getPlayerAssistant().walkTo(0, -3);
            }
        }
    }

    public void firstClickObject(int objectType, int obX, int obY) {
        c.clickObjectType = 0;
        //c.sendMessage("Object type: " + objectType);
        switch (objectType) {
            case 3515:
                if (c.playerLevel[0] >= 98 && c.playerLevel[1] >= 98 && c.playerLevel[2] >= 98 && c.playerLevel[3] >= 98 && c.playerLevel[4] >= 98 && c.playerLevel[5] >= 98 && c.playerLevel[6] >= 98 && c.playerLevel[7] >= 98 && c.playerLevel[8] >= 98 && c.playerLevel[9] >= 98 && c.playerLevel[10] >= 98 && c.playerLevel[11] >= 98 && c.playerLevel[12] >= 98 && c.playerLevel[13] >= 98 && c.playerLevel[14] >= 98 && c.playerLevel[15] >= 98 && c.playerLevel[16] >= 98 && c.playerLevel[17] >= 98 && c.playerLevel[18] >= 98 && c.playerLevel[19] >= 98 && c.playerLevel[20] >= 99 && c.playerLevel[21] >= 98 && c.playerLevel[22] >= 98 && c.playerLevel[23] >= 98) {
                    c.getDH().sendDialogues(3515, 1);
                } else {
                    c.sendMessage("Come back when you have achieved maxed stats!");
                }
                break;
            case 23271:
                wildyditch();
                break;
            case 1765:
                c.getPlayerAssistant().movePlayer(2271, 4680, 0);
                break;

		
		/*case 9391://tzhaar viewing orb
                c.setSidebarInterface(10, 3209);
                c.outStream.createFrame(106); // Writes the frame 106 out.
                c.outStream.writeByteC(10); // Tells client to switch to the magic interface
                break;*/

            case 26288:
            case 26287:
            case 26286:
            case 26289:

                if (c.gwdelay > 1) {
                    c.sendMessage("You can only do this once every 5 minute!");
                    return;
                }
                if (c.playerLevel[5] < c.getPlayerAssistant().getLevelForXP(c.playerXP[5])) {
                    c.startAnimation(645);
                    c.playerLevel[5] = c.getPlayerAssistant().getLevelForXP(c.playerXP[5]);
                    c.sendMessage("You recharge your prayer points.");
                    c.getPlayerAssistant().refreshSkill(5);
                    c.gwdelay = 600;
                } else {
                    c.sendMessage("You already have full prayer points.");
                }

                break;

            case 1:
                c.sendMessage("You found a butterfly Net!");
                c.getItems().addItem(10010, 1);
                break;

            case 2286:
                c.getPlayerAssistant().movePlayer(2595, 4778, 0);
                c.getItems().addItem(995, 2000);
                c.getPlayerAssistant().addSkillXP(125 * c.playerLevel[16], c.playerAgility);
                //c.getPA().addSkillXP(300, 24);
                c.getPlayerAssistant().refreshSkill(c.playerAgility);
                break;


            case 82016:
                if (c.takeAsNote = false) {
                    c.takeAsNote = true;
                } else if (c.takeAsNote = true) {
                    c.takeAsNote = false;
                }
                break;


            case 8972:
                if ((c.playerLevel[21] < 90) && (c.playerLevel[16] < 90)) {
                    c.sendMessage("You need 90 Agility And 90 Hunter to enter the Strykworm's Cave");
                } else {
                    if ((c.playerLevel[21] > 89) && (c.playerLevel[16] < 90)) {
                        c.sendMessage("You need 90 Agility to enter the Strykworm's Cave");
                    } else {
                        if ((c.playerLevel[21] < 90) && (c.playerLevel[16] > 89)) {
                            c.sendMessage("You need 90 Hunter to enter the Strykworm's Cave");
                        } else {
                            if ((c.playerLevel[21] > 89) && (c.playerLevel[16] > 89)) {
                                c.getPlayerAssistant().movePlayer(2515, 4632, 0);
                                c.sendMessage("A sense of nervousness fills your body..");
                                c.sendMessage("you find yourself in a mystery cave!");
                            }
                        }
                    }
                }


                break;


            case 11356:
                if ((c.playerLevel[14] < 85) && (c.playerLevel[18] < 92)) {
                    c.sendMessage("You need 85 Mining And 92 Slayer to face the Frost Dragons");
                } else {
                    if ((c.playerLevel[14] > 84) && (c.playerLevel[18] < 92)) {
                        c.sendMessage("You need 92 Slayer to face the Frost Dragons");
                    } else {
                        if ((c.playerLevel[14] < 85) && (c.playerLevel[18] > 91)) {
                            c.sendMessage("You need 85 Mining to face the Frost Dragons");
                        } else {
                            if ((c.playerLevel[14] > 84) && (c.playerLevel[18] > 91)) {
                                c.getPlayerAssistant().movePlayer(3052, 9577, 0);
                                c.sendMessage("A nervous chill runs down your spine..");
                                c.sendMessage("you find yourself in the Frost Dragons Lair!");
                            }
                        }
                    }
                }


                break;

            case 4150:
                c.getPlayerAssistant().movePlayer(2606, 3154, 0);
                c.sendMessage("Welcome to Funpk!");
                break;


            case 7315:
                c.getPlayerAssistant().movePlayer(2605, 3153, 0);
                c.sendMessage("Welcome to FunPK, Don't Get Owned!");
                break;

            case 7316:
                c.getPlayerAssistant().movePlayer(3095, 3501, 0);
                c.sendMessage("You have returned from FunPk Unharmed!");
                break;

            case 25808:
                c.getPlayerAssistant().openUpBank();
                break;

            case 2471:
                c.getPlayerAssistant().movePlayer(3363, 9638, 0);
                c.sendMessage("Welcome to PkBox!");
                break;

            case 8987:
                c.getPlayerAssistant().movePlayer(3086, 3493, 0);
                break;

            case 6455:
                c.getPlayerAssistant().movePlayer(2837, 3803, 1);
                break;

            case 6456:
                c.getPlayerAssistant().movePlayer(2837, 3806, 0);
                break;

            case 3192:
                c.highscores();
                break;

            case 2469:
                c.getPlayerAssistant().movePlayer(1762, 5180, 0);
                break;

            case 6461:
                c.getPlayerAssistant().movePlayer(2851, 3809, 2);
                break;

            case 13623:
                c.getPlayerAssistant().movePlayer(2837, 3806, 0);
                c.sendMessage("Multi Zone Is Working!");
                break;

            case 15638:
                c.getPlayerAssistant().movePlayer(2841, 3538, 0);
                break;
            case 411:
                if (c.altarPrayed == 0) {
                    c.altarPrayed = 1;
                    c.setSidebarInterface(5, 22500);
                    c.startAnimation(645);
                    c.sendMessage("You sense a surge of power flow through your body!");
                    c.getCombat().resetPrayers();
                } else {
                    c.altarPrayed = 0;
                    c.setSidebarInterface(5, 5608);
                    c.startAnimation(645);
                    c.sendMessage("You sense a surge of purity flow through your body!");
                    c.getCurse().resetCurse();
                }
                break;

            case 13619:
                c.getPlayerAssistant().movePlayer(2717, 9801, 4);
                c.sendMessage("You teleported to tormented demons donator only NPC's!");
                c.sendMessage("You'll only be able to see Donators here, Sorta like world 2...");
                break;
            case 6452:
                if (c.absX == 3304 && c.absY == 9376) {
                    c.getPlayerAssistant().movePlayer(3305, 9376, 4);
                    c.sendMessage("Prepare for the strongest monster in the game!");
                    c.sendMessage("Note: It has 3 waves on it's hp bar!");
                } else {
                    c.autoRet = 0;
                    c.getCombat().resetPlayerAttack();
                    c.getPlayerAssistant().movePlayer(3304, 9376, 0);
                }
                break;
            case 6451:
                if (c.absX == 3304 && c.absY == 9375) {
                    c.getPlayerAssistant().movePlayer(3305, 9375, 4);
                    c.sendMessage("Prepare for the strongest monster in the game!");
                    c.sendMessage("Note: It has 3 waves on it's hp bar!");
                } else {
                    c.autoRet = 0;
                    c.getCombat().resetPlayerAttack();
                    c.getPlayerAssistant().movePlayer(3304, 9375, 0);
                }
                break;
            case 13625:
                c.getPlayerAssistant().movePlayer(2975, 9515, 1);
                c.sendMessage("You teleported to Barrelchest Non-donators");
                c.sendMessage("The Donators portal to barrelchest is 3 barrelchest bosses spawns!");
                break;
            case 13617:
                c.getPlayerAssistant().movePlayer(2975, 9515, 5);
                c.sendMessage("You teleported to Barrelchest Donators");
                c.sendMessage("You will only see Donators here and 3 bosses!!");
                break;
            case 13620:
                c.getPlayerAssistant().movePlayer(2721, 9450, 4);
                c.sendMessage("You teleported to steel/iron donator only NPC's!");
                c.sendMessage("You'll only be able to see Donators here, this makes it alot easier to train.");
                break;
            case 13615:
                c.getPlayerAssistant().movePlayer(3115, 9838, 4);
                c.sendMessage("You teleported to Hill Giants donator only NPC's!");
                c.sendMessage("You'll only be able to see Donators here, this makes it alot easier to train.");
                break;
            case 1738:
                c.getPlayerAssistant().movePlayer(2840, 3539, 2);
                break;
            case 15644:
                if (c.objectX == 2855) {
                    if (c.absX == 2855 && c.absY == 3546) {
                        c.getPlayerAssistant().movePlayer(2855, 3545, 0);
                    } else {
                        c.getPlayerAssistant().movePlayer(2855, 3546, 0);
                    }
                }
                break;
            case 15641:
                if (c.objectX == 2854) {
                    if (c.absX == 2854 && c.absY == 3546) {
                        c.getPlayerAssistant().movePlayer(2854, 3545, 0);
                    } else {
                        c.getPlayerAssistant().movePlayer(2854, 3546, 0);
                    }
                    if (c.absX == 2847 && c.absY == 3540) {
                        c.getPlayerAssistant().movePlayer(2854, 3546, 0);
                    }
                }
                if (c.objectY == 3540) {
                    if (c.absX == 2846 && c.absY == 3540) {
                        //c.getWarriorsGuild().handleKamfreena(c, true);
                        //c.UsedTimer = true;
                    }
                    if (c.absX == 2847 && c.absY == 3540) {
                        //c.getPA().movePlayer(2846, 3540, 2);
                        //c.inCyclops = false;
                        //c.kamfreenaDone = false;
                        //c.UsedTimer = false;
                    }
                }
                break;
            case 2882:
            case 2883:
                if (c.objectX == 3268) {
                    if (c.absX < c.objectX) {
                        c.getPlayerAssistant().walkTo(1, 0);
                    } else {
                        c.getPlayerAssistant().walkTo(-1, 0);
                    }
                }
                break;
            case 272:
                c.getPlayerAssistant().movePlayer(c.absX, c.absY, 1);
                break;

            case 273:
                c.getPlayerAssistant().movePlayer(c.absX, c.absY, 0);
                break;

            case 60:
                c.getPlayerAssistant().movePlayer(3086, 3493, 0);
                break;
            case 26428:
                if (c.Zammy < 15 && c.absX == 2925 && c.absY == 5332) {
                    c.sendMessage("You need atleast 15 Zamorak KC to enter here!");
                    return;
                }
                if (c.absX == 2925 && c.absY == 5332) {
                    c.getPlayerAssistant().movePlayer(2925, 5331, 6);
                    c.Zammy -= 15;
                    c.sendMessage("A magical force reseted your Zamorak kill count!");
                }
                if (c.absX == 2925 && c.absY == 5331) {
                    c.getPlayerAssistant().movePlayer(2925, 5332, 2);
                    c.autoRet = 0;
                    c.getCombat().resetPlayerAttack();
                }
                break;
            case 26425:
                if (c.Band < 15 && c.absX == 2863 && c.absY == 5354) {
                    c.sendMessage("You need atleast 15 Bandos KC to enter here!");
                    return;
                }
                if (c.absX == 2863 && c.absY == 5354) {
                    c.getPlayerAssistant().movePlayer(2864, 5354, 6);
                    c.Band -= 15;
                    c.sendMessage("A magical force reseted your Bandos kill count!");
                }
                if (c.absX == 2864 && c.absY == 5354) {
                    c.getPlayerAssistant().movePlayer(2863, 5354, 2);
                    c.autoRet = 0;
                    c.getCombat().resetPlayerAttack();
                }
                break;
            case 26303:
                c.getPlayerAssistant().movePlayer(2872, 5269, 2);
                break;
            case 26426:
                if (c.Arma < 15 && c.absX == 2839 && c.absY == 5295) {
                    c.sendMessage("You need atleast 15 Armadyl KC to enter here!");
                    return;
                }
                if (c.absX == 2839 && c.absY == 5295) {
                    c.getPlayerAssistant().movePlayer(2839, 5296, 6);
                    c.Arma -= 15;
                    c.sendMessage("A magical force reseted your Armadyl kill count!");
                }
                if (c.absX == 2839 && c.absY == 5296) {
                    c.getPlayerAssistant().movePlayer(2839, 5295, 2);
                    c.autoRet = 0;
                    c.getCombat().resetPlayerAttack();
                }
                break;
            case 26427:
                if (c.Sara < 15 && c.absX == 2908 && c.absY == 5265) {
                    c.sendMessage("You need atleast 15 Saradomin KC to enter here!");
                    return;
                }
                if (c.absX == 2908 && c.absY == 5265) {
                    c.Sara -= 15;
                    c.sendMessage("A magical force reseted your Saradomin kill count!");
                    c.getPlayerAssistant().movePlayer(2907, 5265, 4);
                }
                if (c.absX == 2907 && c.absY == 5265) {
                    c.getPlayerAssistant().movePlayer(2908, 5265, 0);
                    c.autoRet = 0;
                    c.getCombat().resetPlayerAttack();
                }
                break;
            case 2403:
                if (c.Culin == true) {
                    c.getShops().openShop(65);
                    return;
                }
                if (c.Agrith == true && c.Flambeed == false) {
                    c.getShops().openShop(61);
                    return;
                }
                if (c.Flambeed == true && c.Karamel == false) {
                    c.getShops().openShop(62);
                    return;
                }
                if (c.Karamel == true && c.Dessourt == false) {
                    c.getShops().openShop(63);
                    return;
                }
                if (c.Dessourt == true && c.Culin == false) {
                    c.getShops().openShop(64);
                    return;
                }
                if (c.Agrith == false) {
                    c.getShops().openShop(60);
                }
                break;
            case 245:
                c.getPlayerAssistant().movePlayer(c.absX, c.absY + 2, 2);
                break;
            case 26293:
                c.getPlayerAssistant().startTeleport(3086, 3493, 0, "modern");
                break;
            case 246:
                c.getPlayerAssistant().movePlayer(c.absX, c.absY - 2, 1);
                break;
            case 1766:
                c.getPlayerAssistant().movePlayer(3016, 3849, 0);
                break;
            case 410:
                if (c.playerMagicBook == 0) {
                    if (c.playerEquipment[c.playerWeapon] == 4675 || c.playerEquipment[c.playerWeapon] == 15486 || c.playerEquipment[c.playerWeapon] == 15040) {
                        c.setSidebarInterface(0, 328);
                    }
                    c.playerMagicBook = 2;
                    c.setSidebarInterface(6, 16640);
                    c.sendMessage("Your mind becomes stirred with thoughs of dreams.");
                    c.getPlayerAssistant().resetAutocast();
                } else {
                    if (c.playerEquipment[c.playerWeapon] == 4675 || c.playerEquipment[c.playerWeapon] == 15486 || c.playerEquipment[c.playerWeapon] == 15040) {
                        c.setSidebarInterface(0, 328);
                    }
                    c.setSidebarInterface(6, 1151); //modern
                    c.playerMagicBook = 0;
                    c.sendMessage("You feel a drain on your memory.");
                    c.autocastId = -1;
                    c.getPlayerAssistant().resetAutocast();
                }
                break;

            case 6552:
                if (c.playerMagicBook == 0) {
                    if (c.playerEquipment[c.playerWeapon] == 4675 || c.playerEquipment[c.playerWeapon] == 15486 || c.playerEquipment[c.playerWeapon] == 15040) {
                        c.setSidebarInterface(0, 328);
                    }
                    c.playerMagicBook = 1;
                    c.setSidebarInterface(6, 12855);
                    c.sendMessage("An ancient wisdomin fills your mind.");
                    c.getPlayerAssistant().resetAutocast();
                } else {
                    if (c.playerEquipment[c.playerWeapon] == 4675 || c.playerEquipment[c.playerWeapon] == 15486 || c.playerEquipment[c.playerWeapon] == 15040) {
                        c.setSidebarInterface(0, 328);
                    }
                    c.setSidebarInterface(6, 1151); //modern
                    c.playerMagicBook = 0;
                    c.sendMessage("You feel a drain on your memory.");
                    c.autocastId = -1;
                    c.getPlayerAssistant().resetAutocast();
                }
                break;


            case 1816:
                c.getPlayerAssistant().startTeleport2(2271, 4680, 0);
                break;
            case 1817:
                c.getPlayerAssistant().startTeleport(3086, 3493, 0, "modern");
                break;
            case 1814:
                //ardy lever
                c.getPlayerAssistant().startTeleport(3153, 3923, 0, "modern");
                break;

            case 9356:
                c.getPlayerAssistant().enterCaves();
                c.sendMessage("Relog to start the waves, if it bugs up, just relog!");
                break;
            case 12356:
                if (c.Culin == true) {
                    c.sendMessage("You have already finished this minigame!");
                    return;
                }
                if (c.getY() < 3500) {
                    c.getPlayerAssistant().enterRFD();
                    c.sendMessage("Note: this is not a Safe Minigame, you'll lose your items on death!");
                    for (int p = 0; p < c.PRAYER.length; p++) { // reset prayer glows
                        c.prayerActive[p] = false;
                        c.getPlayerAssistant().sendFrame36(c.PRAYER_GLOW[p], 0);
                    }
                } else {
                    c.getPlayerAssistant().resetRFD();
                }
                break;
            case 1733:
                c.getPlayerAssistant().movePlayer(c.absX, c.absY + 6393, 0);
                break;

            case 1734:
                c.getPlayerAssistant().movePlayer(c.absX, c.absY - 6396, 0);
                break;

            case 9357:
                c.getPlayerAssistant().resetTzhaar();
                break;

            case 8959:
                if (c.getX() == 2490 && (c.getY() == 10146 || c.getY() == 10148)) {
                    if (c.getPlayerAssistant().checkForPlayer(2490, c.getY() == 10146 ? 10148 : 10146)) {
                        new Object(6951, c.objectX, c.objectY, c.heightLevel, 1, 10, 8959, 15);
                    }
                }
                break;

            case 2213:
            case 14367:
            case 11758:
            case 3193:
            case 26972:
                c.getPlayerAssistant().openUpBank();
                break;

            case 2996:
                if (c.getItems().playerHasItem(989, 1) && c.getItems().freeSlots() >= 1) {
                    c.getItems().deleteItem(989, 1);
                    c.getItems().addItem(c.getPlayerAssistant().randomCrystal(), 1);
                    c.getDH().sendDialogues(38, 945);
                } else {
                    c.getDH().sendDialogues(37, 945);
                }
                break;

	/*
	Dungeoneering Cases!
						*/
            case 194:
                c.getDH().sendDialogues(235, 0);
                c.sendMessage("Dungeoneering is being re-made right now, please hold on!");
                c.sendMessage("Dungeoneering will be much better once this update is finished.");
                break;
		/* End of Dungeoneering */
            case 10177:
                c.getPlayerAssistant().movePlayer(1890, 4407, 0);
                break;
            case 10230:
                c.getPlayerAssistant().movePlayer(2900, 4449, 0);
                break;
            case 10229:
                c.getPlayerAssistant().movePlayer(1912, 4367, 0);
                break;
            case 2623:
                if (c.absX >= c.objectX)
                    c.getPlayerAssistant().walkTo(-1, 0);
                else
                    c.getPlayerAssistant().walkTo(1, 0);
                break;
            //pc boat
            case 14315:
                c.getPlayerAssistant().movePlayer(2661, 2639, 0);
                break;
            case 14314:
                c.getPlayerAssistant().movePlayer(2657, 2639, 0);
                break;

            case 1596:
            case 1597:
                if (c.getY() >= c.objectY)
                    c.getPlayerAssistant().walkTo(0, -1);
                else
                    c.getPlayerAssistant().walkTo(0, 1);
                break;

            case 14235:
            case 14233:
                if (c.objectX == 2670)
                    if (c.absX <= 2670)
                        c.absX = 2671;
                    else
                        c.absX = 2670;
                if (c.objectX == 2643)
                    if (c.absX >= 2643)
                        c.absX = 2642;
                    else
                        c.absX = 2643;
                if (c.absX <= 2585)
                    c.absY += 1;
                else c.absY -= 1;
                c.getPlayerAssistant().movePlayer(c.absX, c.absY, 0);
                break;
            case 14829:
            case 14830:
            case 14827:
            case 14828:
            case 14826:
            case 14831:
                //Server.objectHandler.startObelisk(objectType);
                Server.objectManager.startObelisk(objectType);
                break;
            case 4387:
                Server.castleWars.joinWait(c, 1);
                break;

            case 4388:
                Server.castleWars.joinWait(c, 2);
                break;


            case 9369:

                if (c.absX == 2399 && c.absY == 5177) {
                    c.getPlayerAssistant().walkTo(0, -2);
                } else {
                    c.getPlayerAssistant().walkTo(0, 2);
                }
                break;

            case 9368:

                if (c.getY() < 5169) {
                    Server.fightPits.removePlayerFromPits(c.playerId);
                    c.getPlayerAssistant().movePlayer(2399, 5169, 0);
                }
                break;
            case 4411:
            case 4415:
            case 4417:
            case 4418:
            case 4419:
            case 4420:
            case 4469:
            case 4470:
            case 4911:
            case 4912:
            case 1757:
                Server.castleWars.handleObjects(c, objectType, obX, obY);
                break;


            //barrows
            //Chest
            case 10284:
                if (c.barrowsKillCount < 5) {
                    c.sendMessage("You haven't killed all the brothers.");
                }
                if (c.barrowsKillCount == 5 && c.barrowsNpcs[c.randomCoffin][1] == 1) {
                    c.sendMessage("I have already summoned this npc.");
                }
                if (c.barrowsNpcs[c.randomCoffin][1] == 0 && c.barrowsKillCount >= 5) {
                    Server.npcHandler.spawnNpc(c, c.barrowsNpcs[c.randomCoffin][0], 3551, 9694 - 1, 0, 0, 120, 30, 200, 200, true, true);
                    c.barrowsNpcs[c.randomCoffin][1] = 1;
                }
                if ((c.barrowsKillCount > 5 || c.barrowsNpcs[c.randomCoffin][1] == 2) && c.getItems().freeSlots() >= 2) {
                    c.getPlayerAssistant().resetBarrows();
                    c.getItems().addItem(c.getPlayerAssistant().randomRunes(), Misc.random(150) + 100);
                    if (Misc.random(2) == 1)
                        c.getItems().addItem(c.getPlayerAssistant().randomBarrows(), 1);
                    c.getPlayerAssistant().startTeleport(3564, 3288, 0, "modern");
                } else if (c.barrowsKillCount > 5 && c.getItems().freeSlots() <= 1) {
                    c.sendMessage("You need at least 2 inventory slot opened.");
                }
                break;
            //doors
            case 6749:
                if (obX == 3562 && obY == 9678) {
                    c.getPlayerAssistant().object(3562, 9678, 6749, -3, 0);
                    c.getPlayerAssistant().object(3562, 9677, 6730, -1, 0);
                } else if (obX == 3558 && obY == 9677) {
                    c.getPlayerAssistant().object(3558, 9677, 6749, -1, 0);
                    c.getPlayerAssistant().object(3558, 9678, 6730, -3, 0);
                }
                break;
            case 6730:
                if (obX == 3558 && obY == 9677) {
                    c.getPlayerAssistant().object(3562, 9678, 6749, -3, 0);
                    c.getPlayerAssistant().object(3562, 9677, 6730, -1, 0);
                } else if (obX == 3558 && obY == 9678) {
                    c.getPlayerAssistant().object(3558, 9677, 6749, -1, 0);
                    c.getPlayerAssistant().object(3558, 9678, 6730, -3, 0);
                }
                break;
            case 6727:
                if (obX == 3551 && obY == 9684) {
                    c.sendMessage("You cant open this door..");
                }
                break;
            case 6746:
                if (obX == 3552 && obY == 9684) {
                    c.sendMessage("You cant open this door..");
                }
                break;
            case 6748:
                if (obX == 3545 && obY == 9678) {
                    c.getPlayerAssistant().object(3545, 9678, 6748, -3, 0);
                    c.getPlayerAssistant().object(3545, 9677, 6729, -1, 0);
                } else if (obX == 3541 && obY == 9677) {
                    c.getPlayerAssistant().object(3541, 9677, 6748, -1, 0);
                    c.getPlayerAssistant().object(3541, 9678, 6729, -3, 0);
                }
                break;
            case 6729:
                if (obX == 3545 && obY == 9677) {
                    c.getPlayerAssistant().object(3545, 9678, 6748, -3, 0);
                    c.getPlayerAssistant().object(3545, 9677, 6729, -1, 0);
                } else if (obX == 3541 && obY == 9678) {
                    c.getPlayerAssistant().object(3541, 9677, 6748, -1, 0);
                    c.getPlayerAssistant().object(3541, 9678, 6729, -3, 0);
                }
                break;
            case 6726:
                if (obX == 3534 && obY == 9684) {
                    c.getPlayerAssistant().object(3534, 9684, 6726, -4, 0);
                    c.getPlayerAssistant().object(3535, 9684, 6745, -2, 0);
                } else if (obX == 3535 && obY == 9688) {
                    c.getPlayerAssistant().object(3535, 9688, 6726, -2, 0);
                    c.getPlayerAssistant().object(3534, 9688, 6745, -4, 0);
                }
                break;
            case 6745:
                if (obX == 3535 && obY == 9684) {
                    c.getPlayerAssistant().object(3534, 9684, 6726, -4, 0);
                    c.getPlayerAssistant().object(3535, 9684, 6745, -2, 0);
                } else if (obX == 3534 && obY == 9688) {
                    c.getPlayerAssistant().object(3535, 9688, 6726, -2, 0);
                    c.getPlayerAssistant().object(3534, 9688, 6745, -4, 0);
                }
                break;
            case 6743:
                if (obX == 3545 && obY == 9695) {
                    c.getPlayerAssistant().object(3545, 9694, 6724, -1, 0);
                    c.getPlayerAssistant().object(3545, 9695, 6743, -3, 0);
                } else if (obX == 3541 && obY == 9694) {
                    c.getPlayerAssistant().object(3541, 9694, 6724, -1, 0);
                    c.getPlayerAssistant().object(3541, 9695, 6743, -3, 0);
                }
                break;
            case 6724:
                if (obX == 3545 && obY == 9694) {
                    c.getPlayerAssistant().object(3545, 9694, 6724, -1, 0);
                    c.getPlayerAssistant().object(3545, 9695, 6743, -3, 0);
                } else if (obX == 3541 && obY == 9695) {
                    c.getPlayerAssistant().object(3541, 9694, 6724, -1, 0);
                    c.getPlayerAssistant().object(3541, 9695, 6743, -3, 0);
                }
                break;
            //end doors
            //coffins
            case 6707: // verac
                c.getPlayerAssistant().movePlayer(3556, 3298, 0);
                break;

            case 6823:
                if (server.model.minigames.Barrows.selectCoffin(c, objectType)) {
                    return;
                }
                if (c.barrowsNpcs[0][1] == 0) {
                    Server.npcHandler.spawnNpc(c, 2030, c.getX(), c.getY() - 1, -1, 0, 120, 25, 200, 200, true, true);
                    c.barrowsNpcs[0][1] = 1;
                } else {
                    c.sendMessage("You have already searched in this sarcophagus.");
                }
                break;

            case 6706: // torag
                c.getPlayerAssistant().movePlayer(3553, 3283, 0);
                break;

            case 6772:
                if (server.model.minigames.Barrows.selectCoffin(c, objectType)) {
                    return;
                }
                if (c.barrowsNpcs[1][1] == 0) {
                    Server.npcHandler.spawnNpc(c, 2029, c.getX() + 1, c.getY(), -1, 0, 120, 20, 200, 200, true, true);
                    c.barrowsNpcs[1][1] = 1;
                } else {
                    c.sendMessage("You have already searched in this sarcophagus.");
                }
                break;


            case 6705: // karil stairs
                c.getPlayerAssistant().movePlayer(3565, 3276, 0);
                break;
            case 6822:
                if (server.model.minigames.Barrows.selectCoffin(c, objectType)) {
                    return;
                }
                if (c.barrowsNpcs[2][1] == 0) {
                    Server.npcHandler.spawnNpc(c, 2028, c.getX(), c.getY() - 1, -1, 0, 90, 17, 200, 200, true, true);
                    c.barrowsNpcs[2][1] = 1;
                } else {
                    c.sendMessage("You have already searched in this sarcophagus.");
                }
                break;

            case 6704: // guthan stairs
                c.getPlayerAssistant().movePlayer(3578, 3284, 0);
                break;
            case 6773:
                if (server.model.minigames.Barrows.selectCoffin(c, objectType)) {
                    return;
                }
                if (c.barrowsNpcs[3][1] == 0) {
                    Server.npcHandler.spawnNpc(c, 2027, c.getX(), c.getY() - 1, -1, 0, 120, 23, 200, 200, true, true);
                    c.barrowsNpcs[3][1] = 1;
                } else {
                    c.sendMessage("You have already searched in this sarcophagus.");
                }
                break;

            case 6703: // dharok stairs
                c.getPlayerAssistant().movePlayer(3574, 3298, 0);
                break;
            case 6771:
                if (server.model.minigames.Barrows.selectCoffin(c, objectType)) {
                    return;
                }
                if (c.barrowsNpcs[4][1] == 0) {
                    Server.npcHandler.spawnNpc(c, 2026, c.getX(), c.getY() - 1, -1, 0, 120, 45, 250, 250, true, true);
                    c.barrowsNpcs[4][1] = 1;
                } else {
                    c.sendMessage("You have already searched in this sarcophagus.");
                }
                break;

            case 6702: // ahrim stairs
                c.getPlayerAssistant().movePlayer(3565, 3290, 0);
                break;
            case 6821:
                if (server.model.minigames.Barrows.selectCoffin(c, objectType)) {
                    return;
                }
                if (c.barrowsNpcs[5][1] == 0) {
                    Server.npcHandler.spawnNpc(c, 2025, c.getX(), c.getY() - 1, -1, 0, 90, 19, 200, 200, true, true);
                    c.barrowsNpcs[5][1] = 1;
                } else {
                    c.sendMessage("You have already searched in this sarcophagus.");
                }
                break;


            case 1276:
            case 1278://trees
                //c.sendMessage("You chop the tree.");
			/* Woodcutting object respawning etc. by lmtruck... making my own - look at this for example
			Objects stump = new Objects(1343, c.objectX, c.objectY, 0, -1, 10, 0);
			Server.objectHandler.addObject(stump);
			Server.objectHandler.placeObject(stump);
			Objects tree = new Objects(c.objectId, c.objectX, c.objectY, 0, -1, 10, 7);
			Server.objectHandler.addObject(tree);*/
                //c.treeId = objectType;
                c.woodcut[0] = 1511;
                c.woodcut[1] = 1;
                c.woodcut[2] = 25;
                c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
                break;

            case 1281: //oak
                c.woodcut[0] = 1521;
                c.woodcut[1] = 15;
                c.woodcut[2] = 37;
                c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
                break;

            case 1308: //willow
                c.woodcut[0] = 1519;
                c.woodcut[1] = 30;
                c.woodcut[2] = 68;
                c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
                break;

            case 1307: //maple
                c.woodcut[0] = 1517;
                c.woodcut[1] = 45;
                c.woodcut[2] = 100;
                c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
                break;

            case 1309: //yew
                c.woodcut[0] = 1515;
                c.woodcut[1] = 60;
                c.woodcut[2] = 175;
                c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
                break;

            case 1306: //yew
                c.woodcut[0] = 1513;
                c.woodcut[1] = 75;
                c.woodcut[2] = 250;
                c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
                break;


            case 2090://copper
            case 2091:
                c.mining[0] = 436;
                c.mining[1] = 1;
                c.mining[2] = 18;
                c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
                break;

            case 2094://tin
                c.mining[0] = 438;
                c.mining[1] = 1;
                c.mining[2] = 18;
                c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
                break;

            case 145856:
            case 2092:
            case 2093: //iron
                c.mining[0] = 440;
                c.mining[1] = 15;
                c.mining[2] = 35;
                c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
                break;

            case 14850:
            case 14851:
            case 14852:
            case 2096:
            case 2097: //coal
                c.mining[0] = 453;
                c.mining[1] = 30;
                c.mining[2] = 50;
                c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
                break;

            case 2098:
            case 2099:
                c.mining[0] = 444;
                c.mining[1] = 40;
                c.mining[2] = 65;
                c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
                break;

            case 2102:
            case 2103:
            case 14853:
            case 14854:
            case 14855: //mith ore
                c.mining[0] = 447;
                c.mining[1] = 55;
                c.mining[2] = 80;
                c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
                break;

            case 2105:
            case 14862: //addy ore
                c.mining[0] = 449;
                c.mining[1] = 70;
                c.mining[2] = 95;
                c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
                break;

            case 14859:
            case 14860: //rune ore
                c.mining[0] = 451;
                c.mining[1] = 85;
                c.mining[2] = 125;
                c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
                break;

            case 8143:
                if (c.farm[0] > 0 && c.farm[1] > 0) {
                    c.getFarming().pickHerb();
                }
                break;

            // DOORS
            case 1516:
            case 1519:
                if (c.objectY == 9698) {
                    if (c.absY >= c.objectY)
                        c.getPlayerAssistant().walkTo(0, -1);
                    else
                        c.getPlayerAssistant().walkTo(0, 1);
                    break;
                }
            case 1530:
            case 1531:
            case 1533:
            case 1534:
            case 11712:
            case 11711:
            case 11707:
            case 11708:
            case 6725:
            case 3198:

            case 3197:
                Server.objectHandler.doorHandling(objectType, c.objectX, c.objectY, 0);
                break;


            case 9319:
                if (c.heightLevel == 0)
                    c.getPlayerAssistant().movePlayer(c.absX, c.absY, 1);
                else if (c.heightLevel == 1)
                    c.getPlayerAssistant().movePlayer(c.absX, c.absY, 2);
                break;

            case 9320:
                if (c.heightLevel == 1)
                    c.getPlayerAssistant().movePlayer(c.absX, c.absY, 0);
                else if (c.heightLevel == 2)
                    c.getPlayerAssistant().movePlayer(c.absX, c.absY, 1);
                break;

            case 4496:
            case 4494:
                if (c.heightLevel == 2) {
                    c.getPlayerAssistant().movePlayer(c.absX - 5, c.absY, 1);
                } else if (c.heightLevel == 1) {
                    c.getPlayerAssistant().movePlayer(c.absX + 5, c.absY, 0);
                }
                break;

            case 4493:
                if (c.heightLevel == 0) {
                    c.getPlayerAssistant().movePlayer(c.absX - 5, c.absY, 1);
                } else if (c.heightLevel == 1) {
                    c.getPlayerAssistant().movePlayer(c.absX + 5, c.absY, 2);
                }
                break;

            case 4495:
                if (c.heightLevel == 1) {
                    c.getPlayerAssistant().movePlayer(c.absX + 5, c.absY, 2);
                }
                break;

            case 5126:
                if (c.absY == 3554)
                    c.getPlayerAssistant().walkTo(0, 1);
                else
                    c.getPlayerAssistant().walkTo(0, -1);
                break;

            case 1759:
                if (c.objectX == 2884 && c.objectY == 3397)
                    c.getPlayerAssistant().movePlayer(c.absX, c.absY + 6400, 0);
                break;
            case 3203: //dueling forfeit
                if (c.duelCount > 0) {
                    c.sendMessage("You may not forfeit yet.");
                    break;
                }
                Client o = (Client) Server.playerHandler.players[c.duelingWith];
                if (o == null) {
                    c.getTradeAndDuel().resetDuel();
                    c.getPlayerAssistant().movePlayer(Config.DUELING_RESPAWN_X + (Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y + (Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
                    break;
                }
                if (c.duelRule[0]) {
                    c.sendMessage("Forfeiting the duel has been disabled!");
                    break;
                }
                if (o != null) {
                    o.getPlayerAssistant().movePlayer(Config.DUELING_RESPAWN_X + (Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y + (Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
                    c.getPlayerAssistant().movePlayer(Config.DUELING_RESPAWN_X + (Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y + (Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
                    o.duelStatus = 6;
                    o.getTradeAndDuel().duelVictory();
                    c.getTradeAndDuel().resetDuel();
                    c.getTradeAndDuel().resetDuelItems();
                    o.sendMessage("The other player has forfeited the duel!");
                    c.sendMessage("You forfeit the duel!");
                    break;
                }

                break;

            case 4008:
                if (c.specAmount < 10.0) {
                    if (c.specRestore > 0) {
                        c.specRestore = 180;
                        c.specAmount = 10.0;
                        c.startAnimation(645);
                        c.getItems().addSpecialBar(c.playerEquipment[c.playerWeapon]);
                        c.sendMessage("Your special attack has been restored.");
                        c.sendMessage("You can only do this every 3 minutes.");
                    } else {
                        c.sendMessage("You must wait at least 3 minutes!");
                    }
                } else {
                    c.sendMessage("You already have full special attack!");
                }
                break;

            case 409:
                if (c.playerLevel[5] < c.getPlayerAssistant().getLevelForXP(c.playerXP[5])) {
                    c.startAnimation(645);
                    c.playerLevel[5] = c.getPlayerAssistant().getLevelForXP(c.playerXP[5]);
                    c.sendMessage("You recharge your prayer points.");
                    c.getPlayerAssistant().refreshSkill(5);
                } else {
                    c.sendMessage("You already have full prayer points.");
                }

                break;
            case 2875:
                if (!c.getItems().ownsCape()) {
                    c.startAnimation(645);
                    c.sendMessage("Guthix blesses you with a cape.");
                    c.getItems().addItem(2413, 1);
                }
                break;
            case 2874:
                if (!c.getItems().ownsCape()) {
                    c.startAnimation(645);
                    c.sendMessage("Zamorak blesses you with a cape.");
                    c.getItems().addItem(2414, 1);
                }
                break;
            case 2879:
                c.getPlayerAssistant().movePlayer(2538, 4716, 0);
                break;
            case 2878:
                c.getPlayerAssistant().movePlayer(2509, 4689, 0);
                break;
            case 5960:
                c.getPlayerAssistant().startTeleport2(3090, 3956, 0);
                break;

            case 1815:
                c.getPlayerAssistant().startTeleport2(Config.EDGEVILLE_X, Config.EDGEVILLE_Y, 0);
                break;

            case 9706:
                c.getPlayerAssistant().startTeleport2(3105, 3951, 0);
                break;
            case 9707:
                c.getPlayerAssistant().startTeleport2(3105, 3956, 0);
                break;

            case 5959:
                c.getPlayerAssistant().startTeleport2(2539, 4712, 0);
                break;

            case 2558:
                c.sendMessage("This door is locked.");
                break;

            case 9294:
                if (c.absX < c.objectX) {
                    c.getPlayerAssistant().movePlayer(c.objectX + 1, c.absY, 0);
                } else if (c.absX > c.objectX) {
                    c.getPlayerAssistant().movePlayer(c.objectX - 1, c.absY, 0);
                }
                break;
            case 9293:
                if (c.absX < c.objectX) {
                    c.getPlayerAssistant().movePlayer(2892, 9799, 0);
                } else {
                    c.getPlayerAssistant().movePlayer(2886, 9799, 0);
                }
                break;
            case 10529:
            case 10527:
                if (c.absY <= c.objectY)
                    c.getPlayerAssistant().walkTo(0, 1);
                else
                    c.getPlayerAssistant().walkTo(0, -1);
                break;
            case 3044:
                c.getSmithing().sendSmelting();
                break;
            case 733:
                c.startAnimation(451);
			/*if (Misc.random(1) == 1) {
				c.getPA().removeObject(c.objectX, c.objectY);
				c.sendMessage("You slash the web.");
			} else {
				c.sendMessage("You fail to slash the webs.");
			}*/
                if (c.objectX == 3158 && c.objectY == 3951) {
                    new Object(734, c.objectX, c.objectY, c.heightLevel, 1, 10, 733, 50);
                } else {
                    new Object(734, c.objectX, c.objectY, c.heightLevel, 0, 10, 733, 50);
                }
                break;

            default:
                ScriptManager.callFunc("objectClick1_" + objectType, c, objectType, obX, obY);
                break;

        }
    }

    public void secondClickObject(int objectType, int obX, int obY) {
        c.clickObjectType = 0;
        //c.sendMessage("Object type: " + objectType);
        switch (objectType) {
            case 11666:
            case 3044:
                c.getSmithing().sendSmelting();
                break;
            case 26288:
            case 26287:
            case 26286:
            case 26289:
                c.autoRet = 0;
                c.getCombat().resetPlayerAttack();
                c.getPlayerAssistant().movePlayer(2882, 5310, 2);
                c.sendMessage("You teleported out of the god's chamber.");
                break;
            case 2213:
            case 14367:
            case 11758:
                c.getPlayerAssistant().openUpBank();
                break;


            case 4874:
                c.getThieving().stealFromStall(1897, 10, 1);
                break;
            case 4875:
                c.getThieving().stealFromStall(950, 30, 25);
                break;
            case 4876:
                c.getThieving().stealFromStall(1635, 60, 50);
                break;
            case 4877:
                c.getThieving().stealFromStall(7650, 100, 75);
                break;
            case 4878:
                c.getThieving().stealFromStall(1613, 170, 90);
                break;


            case 6163:
                c.getThieving().stealFromStall(2503, 120, 80);
                break;
            case 6165:
                c.getThieving().stealFromStall(4089, 170, 90);
                break;
            case 6166:
                c.getThieving().stealFromStall(2509, 200, 99);
                break;


            case 2558:
                if (System.currentTimeMillis() - c.lastLockPick < 3000 || c.freezeTimer > 0)
                    break;
                if (c.getItems().playerHasItem(1523, 1)) {
                    c.lastLockPick = System.currentTimeMillis();
                    if (Misc.random(10) <= 3) {
                        c.sendMessage("You fail to pick the lock.");
                        break;
                    }
                    if (c.objectX == 3044 && c.objectY == 3956) {
                        if (c.absX == 3045) {
                            c.getPlayerAssistant().walkTo2(-1, 0);
                        } else if (c.absX == 3044) {
                            c.getPlayerAssistant().walkTo2(1, 0);
                        }

                    } else if (c.objectX == 3038 && c.objectY == 3956) {
                        if (c.absX == 3037) {
                            c.getPlayerAssistant().walkTo2(1, 0);
                        } else if (c.absX == 3038) {
                            c.getPlayerAssistant().walkTo2(-1, 0);
                        }
                    } else if (c.objectX == 3041 && c.objectY == 3959) {
                        if (c.absY == 3960) {
                            c.getPlayerAssistant().walkTo2(0, -1);
                        } else if (c.absY == 3959) {
                            c.getPlayerAssistant().walkTo2(0, 1);
                        }
                    }
                } else {
                    c.sendMessage("I need a lockpick to pick this lock.");
                }
                break;
            default:
                ScriptManager.callFunc("objectClick2_" + objectType, c, objectType, obX, obY);
                break;
        }
    }


    public void thirdClickObject(int objectType, int obX, int obY) {
        c.clickObjectType = 0;
        c.sendMessage("Object type: " + objectType);
        switch (objectType) {
            default:
                ScriptManager.callFunc("objectClick3_" + objectType, c, objectType, obX, obY);
                break;
        }
    }

    public void firstClickNpc(int npcType) {
        c.fishitem = -1;
        c.clickNpcType = 0;
        c.npcClickIndex = 0;
        if (c.fishitem != -1) {
            if (!c.getItems().playerHasItem(c.fishitem)) {
                c.sendMessage("You need a " + c.getItems().getItemName(c.fishitem) + " to fish for " + c.getItems().getItemName(c.fishies));
                c.fishing = false;
                return;
            }
            if (c.getItems().freeSlots() == 0) {
                c.sendMessage("Your inventory is full.");
                c.fishing = false;
                return;
            }
            if (c.playerFishing < c.fishreqt) {
                c.sendMessage("You need a fishing level of " + c.fishreqt + " to fish here.");
                c.fishing = false;
                return;
            }
            c.fishtimer = c.getFishing().fishtime(c.fishies, c.fishreqt);
        }
        switch (npcType) {
            case 1396:
                c.getDH().sendDialogues(1396, npcType);
                break;
            case 216:
                c.getDH().sendDialogues(216, npcType);
                break;
            case 56:
                c.getDH().sendDialogues(1599, npcType);
                break;
            case 541:
                c.getDH().sendDialogues(5757, npcType);
                break;
            case 8206:
                if (c.playerRights < 1) {
                    c.getDH().sendDialogues(185, 0);
                } else {
                    c.sendMessage("Your rank is too high to participate in the lottery!");
                }
                break;
            case 783:
                if (c.nomad == 0) {
                    c.getDH().sendDialogues(360, npcType);
                } else if (c.nomad == 1) {
                    c.getDH().sendDialogues(369, npcType);
                } else if (c.nomad == 2) {
                    c.getDH().sendDialogues(385, npcType);
                } else if (c.nomad == 3 || c.nomad == 4 || c.nomad == 5 || c.nomad == 6 || c.nomad == 7 || c.nomad == 8) {
                    c.getDH().sendDialogues(393, npcType);
                } else if (c.nomad == 9 || c.nomad == 10) {
                    c.getDH().sendDialogues(416, npcType);
                } else {
                    c.sendMessage("This NPC has nothing to say at the moment");
                }
                break;
            case 302:
                if (c.nomad == 1) {
                    c.getDH().sendDialogues(370, 302);
                } else if (c.nomad == 2) {
                    c.getDH().sendDialogues(381, 302);
                } else if (c.nomad == 3) {
                    c.getDH().sendDialogues(394, 302);
                } else if (c.nomad == 4) {
                    c.getDH().sendDialogues(398, 302);
                } else if (c.nomad == 5) {
                    c.getDH().sendDialogues(402, 302);
                } else if (c.nomad == 6) {
                    c.getDH().sendDialogues(404, 302);
                } else if (c.nomad == 7 || c.nomad == 8) {
                    c.getDH().sendDialogues(409, 302);
                } else if (c.nomad == 9) {
                    c.getDH().sendDialogues(415, npcType);
                } else {
                    c.sendMessage("This NPC has nothing to say at the moment");
                }
                break;
            case 706:
                if (c.nomad == 7) {
                    c.getDH().sendDialogues(410, npcType);
                } else if (c.nomad == 8) {
                    c.getDH().sendDialogues(410, npcType);
                } else if (c.nomad == 9) {
                    c.getDH().sendDialogues(414, npcType);
                } else {
                    c.sendMessage("This NPC is too busy to speak at the moment");
                }
                break;
            case 251:
                c.getDH().sendDialogues(4420, npcType);
                break;
            case 252:
                c.getDH().sendDialogues(252, npcType);
                break;
            case 1683:
                c.getDH().sendDialogues(9881, npcType);
                break;
            case 598:
                c.getDH().sendDialogues(4443, npcType);
                break;
            case 519:
                c.getDH().sendDialogues(1399, 519);
                break;
            case 597:
                c.getDH().sendDialogues(4442, npcType);
                break;
            case 2537:
                c.getShops().openShop(20);
                break;
            case 888:
                c.getShops().openShop(21);
                break;
            case 37:
                if (c.playerRights > 5) {
                    c.getShops().openShop(22);
                    break;
                } else {
                    c.sendMessage("Sorry, This Shop is for Dicers only.");
                    break;
                }


            case 304:
                c.getDH().sendDialogues(1660, npcType);
                break;
            case 561:
                c.getDH().sendDialogues(5757, npcType);
                break;
            case 638:
                c.getDH().sendDialogues(5758, npcType);
                break;
            case 591:
                c.getDH().sendDialogues(5759, npcType);
                break;
            case 2830:
                c.getDH().sendDialogues(4439, npcType);
                break;
            case 2244:
                c.getDH().sendDialogues(170, npcType);
                break;
            default:
            case 875:
                if (c.absX > 3076 && c.absX < 3083 && c.absY > 3506 && c.absY < 3501) {
                    c.getShops().openPlayerShop(c);
                }
                break;
            case 2127:
                if (c.playerCollect > 0) {
                    c.sendMessage("You succesfully collected " + c.playerCollect + " coins.");
                    c.getItems().addItem(995, c.playerCollect);
                    c.playerCollect = 0;
                } else {
                    c.sendMessage("You dont have anything to collect");
                }
                break;

            case 707:
                c.getDH().sendDialogues(9, npcType);
                break;
            case 7601:
                c.getDH().sendDialogues(70, 4289);
                break;
            case 9994:
                c.getDH().sendDialogues(175, 37);
                break;
            case 6873:
                c.getDH().sendDialogues(75, 4289);
                break;
            case 946:
                c.getDH().sendDialogues(20, npcType);
                break;
            case 316:
                c.fishing = true;
                c.fishXP = 1000;
                c.fishies = 317;
                c.fishreqt = 0;
                c.fishitem = 303;
                c.fishemote = 621;
                c.fishies2 = 0;
                c.fishreq2 = 0;
                break;
            case 334:
                c.fishing = true;
                c.fishXP = 1000;
                c.fishies = 317;
                c.fishreqt = 0;
                c.fishitem = 303;
                c.fishemote = 621;
                c.fishies2 = 0;
                c.fishreq2 = 0;
                break;
            case 324://cage-harpoon spot choice cage
                c.fishing = true;
                c.fishXP = 3000;
                c.fishies = 377;
                c.fishreqt = 40;
                c.fishitem = 301;
                c.fishemote = 619;
                c.fishies2 = 389;
                c.fishreq2 = 81;
                break;
            case 325:
                c.fishing = true;
                c.fishXP = 10000;
                c.fishies = 15272;
                c.fishreqt = 40;
                c.fishitem = 301;
                c.fishemote = 619;
                c.fishies2 = 15272;
                c.fishreq2 = 99;
                break;
            case 8647:
                c.fishing = true;
                c.fishXP = 10000;
                c.fishies = 17797;
                c.fishreqt = 80;
                c.fishitem = 301;
                c.fishemote = 619;
                c.fishies2 = 17797;
                c.fishreq2 = 80;
                break;
            case 320:
                c.fishing = true;
                c.fishXP = 10000;
                c.fishies = 15272;
                c.fishreqt = 40;
                c.fishitem = 301;
                c.fishemote = 619;
                c.fishies2 = 15272;
                c.fishreq2 = 95;
                break;
            case 326:
                c.fishing = true;
                c.fishXP = 3000;
                c.fishies = 341;
                c.fishreqt = 23;
                c.fishitem = 303;
                c.fishemote = 621;
                c.fishies2 = 363;
                c.fishreq2 = 46;
                break;
            case 313:
                c.fishing = true;
                c.fishXP = 3000;
                c.fishies = 341;
                c.fishreqt = 23;
                c.fishitem = 303;
                c.fishemote = 621;
                c.fishies2 = 363;
                c.fishreq2 = 46;
                break;
            case 3100:
                c.getPlayerAssistant().movePlayer(2717, 9801, 0);
                c.sendMessage("Goodluck killing the creatures from hell!");
                break;
            case 4289:
                c.kamfreenaDone = true;
                c.getDH().sendDialogues(47, 4289);
                break;
            case 1061:
                c.inCyclops = true;
                c.getWarriorsGuild().handleKamfreena(c, true);
                break;
            case 1062:
                c.kamfreenaDone = false;
                c.inCyclops = false;
                c.getWarriorsGuild().handleKamfreena(c, true);
                break;
            case 2258:
                c.getDH().sendDialogues(110, npcType);
                break;
            case 2261:
                c.getPlayerAssistant().walkableInterface(-1);
                c.getPlayerAssistant().movePlayer(2885, 5330, 2);
                break;

            case 2259:
                c.getPlayerAssistant().movePlayer(2885, 5345, 2);
                c.getPlayerAssistant().walkableInterface(12418);
                c.sendMessage("You have entered Zamorak, To leave talk to me on the other side.");
                break;
            case 398:
                c.getPlayerAssistant().movePlayer(2918, 5273, 0);
                c.sendMessage("You have entered Saradomin, To leave talk to me on the other side.");
                break;
            case 399:
                c.getPlayerAssistant().movePlayer(2911, 5299, 2);
                break;
            case 1064:
                c.getPlayerAssistant().movePlayer(2852, 5333, 2);
                break;

            case 1063:
                c.getPlayerAssistant().movePlayer(2849, 5333, 2);
                c.sendMessage("You have entered Bandos, To leave talk to me on the other side.");
                break;

            case 70:
                c.getPlayerAssistant().movePlayer(2872, 5269, 2);
                c.sendMessage("You have entered Armadyl, To leave click the Pillar.");
                c.sendMessage("Note: Ruby bolts (e) and Diamond bolts (e) are recommended!");
                break;
            case 8275:
                if (c.slayerTask <= 0) {
                    c.getDH().sendDialogues(11, npcType);
                } else {
                    c.getDH().sendDialogues(13, npcType);
                }
                break;
            case 500:
                if (c.monkeyk0ed >= 20) {
                    c.getDH().sendDialogues(30, npcType);
                } else {
                    c.getDH().sendDialogues(32, npcType);
                }
                break;
            case 793:
                c.getShops().openShop(83);
                //c.getPA().showInterface(18070);
//c.getPA().sendFrame126(""+c.dungPoints+"", 18071);
                //c.sendMessage("You currently have <col=255>" + c.dungPoints + "</col> Dungeoneering Points.");
                break;
            case 9711:
                c.getShops().openShop(84);
                //c.sendMessage("You currently have <col=255>" + c.dungPoints + "</col> Dungeoneering Points.");
                break;
            case 9713:
                c.getShops().openShop(85);
                break;
            case 8000:
                c.getDH().sendDialogues(505, npcType);
                c.getPlayerAssistant().sendFrame126("" + c.dungPoints + "", 18071);
                c.sendMessage("You currently have <col=255>" + c.dungPoints + "</col> Dungeoneering Points.");
                break;
            case 692:
                c.getShops().openShop(90);
                break;
            case 286:
                c.getShops().openShop(92);
                break;
            case 9400:
                c.getShops().openShop(93);
                break;
            case 919:
                c.getShops().openShop(10);
                break;
            case 1008:
                c.getShops().openShop(82);
                c.getItems().deleteItem(12093, 1);
                c.getItems().deleteItem(12087, 1);
                c.getItems().deleteItem(12031, 1);
                c.getItems().deleteItem(12007, 1);
                break;
            case 9716:
                c.getShops().openShop(81);
                c.getItems().deleteItem(12093, 1);
                c.getItems().deleteItem(12087, 1);
                c.getItems().deleteItem(12031, 1);
                c.getItems().deleteItem(12007, 1);
                break;
            case 9715:
                c.getShops().openShop(80);
                c.getItems().deleteItem(12093, 1);
                c.getItems().deleteItem(12087, 1);
                c.getItems().deleteItem(12031, 1);
                c.getItems().deleteItem(12007, 1);
                break;
            case 1202:
                c.getShops().openShop(79);
                c.getItems().deleteItem(12093, 1);
                c.getItems().deleteItem(12087, 1);
                c.getItems().deleteItem(12031, 1);
                c.getItems().deleteItem(12007, 1);
                break;
            case 560:
                c.getShops().openShop(78);
                c.getItems().deleteItem(12093, 1);
                c.getItems().deleteItem(12087, 1);
                c.getItems().deleteItem(12031, 1);
                c.getItems().deleteItem(12007, 1);
                break;
            case 3381:
                c.getShops().openShop(76);
                break;
            case 6750:
                c.getShops().openShop(77);
                break;
            case 5030:
                c.getShops().openShop(74);
                c.sendMessage("You currently have <col=255>" + c.pkPoints + "</col> Pk points.");
                break;
            case 1294:
                c.getShops().openShop(72);
                break;
            case 5839:
                c.getShops().openShop(75);
                break;

            case 1778:
                c.getShops().openShop(71);
                break;
            case 1779:
                c.getShops().openShop(67);
                break;
            case 554:
                c.getShops().openShop(68);
                break;
            case 520:
                c.getShops().openShop(69);
                break;
            case 542:
                c.getShops().openShop(9);
                break;
            case 683:
                c.getDH().sendDialogues(5758, npcType);
                break;
            case 4290:
                c.getShops().openShop(66);
                break;
            case 549:
                c.getShops().openShop(4);
                break;

            //hunter

            //implin's
            case 6055:
                c.CatchimpNpc("Baby Impling", 10010, 6055, 11238, 1500, 1, c.playerId);
                break;
            case 6056:
                c.CatchimpNpc("Young Impling", 10010, 6056, 11240, 3500, 17, c.playerId);
                break;
            case 6057:
                c.CatchimpNpc("Gourmet Impling", 10010, 6057, 11242, 4000, 20, c.playerId);
                break;
            case 6058:
                c.CatchimpNpc("Earth Impling", 10010, 6058, 11244, 5000, 34, c.playerId);
                break;
            case 6059:
                c.CatchimpNpc("Essence impling", 10010, 6059, 11246, 6000, 40, c.playerId);
                break;
            case 6060:
                c.CatchimpNpc("Electic impling", 10010, 6060, 11248, 8000, 50, c.playerId);
                break;
            case 6061:
                c.CatchimpNpc("Nature impling", 10010, 6061, 11250, 10000, 58, c.playerId);
                break;
            case 6062:
                c.CatchimpNpc("Magpie impling", 10010, 6062, 11252, 12500, 65, c.playerId);
                break;
            case 6063:
                c.CatchimpNpc("Ninja impling", 10010, 6063, 11254, 14000, 74, c.playerId);
                break;
            case 6064:
                c.CatchimpNpc("Dragon Impling", 10010, 6064, 11256, 25000, 90, c.playerId);
                break;

            //end of implin's!

            //butterfly's
            case 5082:
                c.CatchHunterNpc("Black Warlock", 10010, 5082, 10014, 18000, 85, c.playerId);
                break;
            case 5083:
                c.CatchHunterNpc("Snowy Knight", 10010, 5083, 10016, 15000, 75, c.playerId);
                break;
            case 5084:
                c.CatchHunterNpc("Sapphire Glacialis", 10010, 5084, 10018, 7500, 45, c.playerId);
                break;
            case 5085:
                c.CatchHunterNpc("Ruby Harvest", 10010, 5085, 10020, 5000, 30, c.playerId);
                break;
            //end of butterfly's

            // end of hunter :)
            case 2538:
                c.getShops().openShop(6);
                break;

            case 1282:
                c.getShops().openShop(7);
                break;
            case 1152:
                c.getDH().sendDialogues(16, npcType);
                break;
            case 5580:
                c.getDH().sendDialogues(70, npcType);
                break;
            case 494:
                c.getPlayerAssistant().openUpBank();
                break;
            case 2566:
                c.getShops().openSkillCape();
                break;
            case 3788:
                c.getShops().openVoid();
                break;
            case 905:
                c.getDH().sendDialogues(5, npcType);
                break;
            case 460:
                c.getDH().sendDialogues(3, npcType);
                break;
            case 6138:
                c.getDH().sendDialogues(200, npcType);
                break;
            case 6139:
                c.getDH().sendDialogues(150, npcType);
                break;
            case 462:
                c.getDH().sendDialogues(7, npcType);
                break;
            case 6970:
                c.getShops().openShop(13);
                break;
            case 6971:
                c.getShops().openShop(12);
                break;
            case 522:
            case 523:
                c.getShops().openShop(1);
                break;
            case 599:
                c.getPlayerAssistant().showInterface(3559);
                c.canChangeAppearance = true;
                break;
            case 904:
                c.sendMessage("You have " + c.magePoints + " points.");
                break;

        }
    }

    public void store(int i, int npcType) {
        switch (npcType) {
            case 6807:
                if (Server.npcHandler.npcs[i].npcId == c.summoningnpcid) {
                    c.sendMessage("You are now storing items inside your npc");
                    c.getSummoning().store();
                }
                break;
        }
    }

    public void secondClickNpc(int npcType) {
        c.fishitem = -1;
        c.clickNpcType = 0;
        c.npcClickIndex = 0;
        if (c.fishitem != -1) {
            if (!c.getItems().playerHasItem(c.fishitem)) {
                c.sendMessage("You need a " + c.getItems().getItemName(c.fishitem) + " to fish for " + c.getItems().getItemName(c.fishies));
                c.fishing = false;
                return;
            }
            if (c.getItems().freeSlots() == 0) {
                c.sendMessage("Your inventory is full.");
                c.fishing = false;
                return;
            }

            if (c.playerFishing < c.fishreqt) {
                c.sendMessage("You need a fishing level of " + c.fishreqt + " to fish here.");
                c.fishing = false;
                return;
            }
            c.fishtimer = c.getFishing().fishtime(c.fishies, c.fishreqt);
        }
        switch (npcType) {
            case 252:
                c.getPlayerAssistant().showInterface(14040);
                break;
            case 2258:
                c.getDH().sendDialogues(17, npcType);
                break;

            case 251: //This is the npc, change if you want too
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(10)) {
                        c.sendMessage("You need level 10 in ALL LEVELS to view the lowest shop");
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(10) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(20)) {
                        c.getShops().openShop(91); //this is one shop make in your shops.cfg (along with the others)
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(20) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(30)) {
                        c.getShops().openShop(92);
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(30) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(40)) {
                        c.getShops().openShop(93);
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(40) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(50)) {
                        c.getShops().openShop(94);
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(50) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(60)) {
                        c.getShops().openShop(95);
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(60) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(70)) {
                        c.getShops().openShop(96);
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(70) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(80)) {
                        c.getShops().openShop(97);
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(80) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(90)) {
                        c.getShops().openShop(98);
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(90) && c.playerXP[i] <= c.getPlayerAssistant().getXPForLevel(99)) {
                        c.getShops().openShop(99);
                        return;
                    }
                }
                for (int i = 0; i < 21; i++) {
                    if (c.playerXP[i] >= c.getPlayerAssistant().getXPForLevel(99)) {
                        c.getShops().openShop(100);
                    }
                }
                break;
            case 2244:
                c.getPlayerAssistant().showInterface(26099);
                c.getPlayerAssistant().sendFrame200(26101, 9847);//chatid
                c.getPlayerAssistant().sendFrame185(26101);
                if (c.KC > c.DC) {
                    c.getPlayerAssistant().sendFrame126("@or1@Kills: @gre@" + c.KC + " ", 26105);
                    c.getPlayerAssistant().sendFrame126("@or1@Deaths: @red@" + c.DC + "", 26106);
                }
                if (c.KC < c.DC) {
                    c.getPlayerAssistant().sendFrame126("@or1@Kills: @red@" + c.KC + "", 26105);
                    c.getPlayerAssistant().sendFrame126("@or1@Deaths: @gre@" + c.DC + "", 26106);
                }
                c.getPlayerAssistant().sendFrame126("@or1@Name: @gre@" + c.playerName + "", 26107);
                c.getPlayerAssistant().sendFrame126("@or1@Combat Level: @gre@" + c.combatLevel + "", 26108);
                if (c.playerRights == 0) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Player", 26109);
                }
                if (c.playerRights == 1) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Bronze Donator", 26109);
                }
                if (c.playerRights == 2) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Iron Donator", 26109);
                }
                if (c.playerRights == 3) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Adamant Donator", 26109);
                }
                if (c.playerRights == 4) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Rune Donator", 26109);
                }
                if (c.playerRights == 5) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Dragon Donator", 26109);
                }
                if (c.playerRights == 6) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Dicer", 26109);
                }
                if (c.playerRights == 7) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Veteran", 26109);
                }
                if (c.playerRights == 8) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Helper", 26109);
                }
                if (c.playerRights == 9) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Trial Moderator", 26109);
                }
                if (c.playerRights == 10) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Moderator", 26109);
                }
                if (c.playerRights == 11) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Administrator", 26109);
                }
                if (c.playerRights == 12) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Co-Owner", 26109);
                }
                if (c.playerRights == 13) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Owner", 26109);
                }
                if (c.playerRights == 14) {
                    c.getPlayerAssistant().sendFrame126("@or1@Rank: @gre@Developer", 26109);
                }
                c.getPlayerAssistant().sendFrame126("@or1@Dung Points: @gre@" + c.dungPoints + " ", 26111);
                c.getPlayerAssistant().sendFrame126("@or1@Slayer Points: @gre@" + c.SPoints + "", 26112);
                c.getPlayerAssistant().sendFrame126("@or1@PK points: @gre@" + c.pkPoints + "  ", 26113);
                c.getPlayerAssistant().sendFrame126("@or1@Vote Points: @gre@" + c.votePoints + "", 26115);
                c.getPlayerAssistant().sendFrame126("@or1@Level Points: @gre@" + c.levelPoints + "  ", 26116);
                c.getPlayerAssistant().sendFrame126("@or1@Donator Points: @gre@" + c.donatorPoints + "", 26117);

                c.getPlayerAssistant().sendFrame126("@or1@Pest Control Points: @gre@" + c.pcPoints + "", 26118);
                c.getPlayerAssistant().sendFrame126("@or1@Suggest on forums.", 26119);
                c.getPlayerAssistant().sendFrame126("@or1@Suggest on forums.", 26120);
                c.getPlayerAssistant().sendFrame126("@or1@Suggest on forums.", 26121);
                c.getPlayerAssistant().sendFrame126("@or1@Suggest on forums.", 26122);
                c.updateRequired = true;
                c.appearanceUpdateRequired = true;
            case 526:
                break;
            case 1282:
                c.getShops().openShop(7);
                break;
            case 598:
                c.getDH().sendDialogues(4444, npcType);
                break;
            case 597:
                c.getDH().sendDialogues(4445, npcType);
                break;
            case 1683:
                c.getShops().openShop(58);
                break;
            case 8275:
                c.getShops().openShop(48);
                break;
            case 2830:
                c.getShops().openShop(73);
                c.sendMessage("<col=255>You currently have " + c.pkPoints + " PK Points.</col>");
                break;
            case 333:
                c.fishing = true;
                c.fishXP = 650;
                c.fishies = 359;
                c.fishreqt = 35;
                c.fishitem = 311;
                c.fishemote = 618;
                c.fishies2 = 371;
                c.fishreq2 = 50;
                break;
            case 312:
                c.fishing = true;
                c.fishXP = 650;
                c.fishies = 359;
                c.fishreqt = 35;
                c.fishitem = 311;
                c.fishemote = 618;
                c.fishies2 = 371;
                c.fishreq2 = 50;
                break;
            case 324:
                c.fishing = true;
                c.fishXP = 10000;
                c.fishies = 359;
                c.fishreqt = 35;
                c.fishitem = 311;
                c.fishemote = 618;
                c.fishies2 = 371;
                c.fishreq2 = 50;
                break;
            case 334:
                c.fishing = true;
                c.fishXP = 10000;
                c.fishies = 359;
                c.fishreqt = 35;
                c.fishitem = 311;
                c.fishemote = 618;
                c.fishies2 = 371;
                c.fishreq2 = 50;
                break;
            case 316:
                c.fishing = true;
                c.fishXP = 630;
                c.fishies = 327;
                c.fishreqt = 5;
                c.fishitem = 307;
                c.fishemote = 622;
                c.fishies2 = 345;
                c.fishreq2 = 10;
                break;
            case 326:
                c.fishing = true;
                c.fishXP = 530;
                c.fishies = 327;
                c.fishreqt = 5;
                c.fishitem = 307;
                c.fishemote = 622;
                c.fishies2 = 345;
                c.fishreq2 = 10;
                break;
            case 331:
                c.fishing = true;
                c.fishXP = 770;
                c.fishies = 349;
                c.fishreqt = 25;
                c.fishitem = 307;
                c.fishemote = 622;
                c.fishies2 = 0;
                c.fishreq2 = 0;


            case 313:
                c.fishing = true;
                c.fishXP = 1000;
                c.fishies = 383;
                c.fishreqt = 79;
                c.fishitem = 311;
                c.fishemote = 618;
                c.fishies2 = 0;
                c.fishreq2 = 0;
                break;
            case 3788:
                c.getShops().openVoid();
                break;
            case 494:
                c.getPlayerAssistant().openUpBank();
                break;
            case 904:
                c.getShops().openShop(17);
                break;
            case 522:
            case 523:
                c.getShops().openShop(1);
                break;

            case 549:
                c.getShops().openShop(4);
                break;

            case 659:
                c.getShops().openShop(72);
                break;

            case 170:
                c.getPlayerAssistant().showInterface(802);
                break;

            case 2538:
                c.getShops().openShop(6);
                break;
            case 1:
            case 9:
            case 18:
            case 20:
            case 26:
            case 21:
                c.getThieving().stealFromNPC(npcType);
                break;
            default:
                ScriptManager.callFunc("npcClick2_" + npcType, c, npcType);
                if (c.playerRights == 3)
                    Misc.println("Second Click Npc : " + npcType);
                break;

        }
    }

    public void thirdClickNpc(int npcType) {
        c.clickNpcType = 0;
        c.npcClickIndex = 0;
        switch (npcType) {
            case 2830:
                c.getShops().openShop(59);
                c.sendMessage("<col=255>You currently have " + c.levelPoints + " Level Points.</col>");
                break;
            case 8275:
                c.getShops().openShop(48);
                c.sendMessage("You currently have <col=255>" + c.SPoints + "</col> slayerpoints.");
                ScriptManager.callFunc("npcClick3_" + npcType, c, npcType);
                if (c.playerRights == 3)
                    Misc.println("Third Click NPC : " + npcType);
                break;


        }
    }


}