package edu.kit.informatik.commands;

import edu.kit.informatik.game.Phase;
import edu.kit.informatik.game.godfavor.GodFavor;
import edu.kit.informatik.game.godfavor.effects.IdunsRegeneration;
import edu.kit.informatik.game.godfavor.effects.ThorsLightning;
import edu.kit.informatik.game.godfavor.effects.ThrymrsThief;
import edu.kit.informatik.game.items.Damagetype;
import edu.kit.informatik.game.items.Item;
import edu.kit.informatik.main.Main;
import edu.kit.informatik.messages.Errors;
import edu.kit.informatik.utils.Terminal;
import edu.kit.informatik.utils.Variables;

/**
 * Command witch evaluates the current standing.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class EvaluateCommand {

    /**
     * Command-object.
     * */
    public EvaluateCommand() {

    }

    /**
     * Evaluets the game.
     * */
    public void evaluate() {
        evalLifes();
        evalGodPower();
        evalGodFavor();
        evalItems();

    }

    private static void evalGodFavor() {
        GodFavor player1 = Variables.player1.getGodFavor();
        GodFavor player2 = Variables.player2.getGodFavor();

        if (player1 != null && player1.getAbbreviation().equals("TT")) {
            ThrymrsThief.play(Variables.player1);
        } else if (player2 != null && player2.getName().equals("TT")) {
            ThrymrsThief.play(Variables.player2);
        } else if (player1 != null && player1.getAbbreviation().equals("TS")) {
            ThorsLightning.play(Variables.player1);
        } else if (player2 != null && player2.getAbbreviation().equals("TS")) {
            ThorsLightning.play(Variables.player2);
        } else if (player1 != null && player1.getAbbreviation().equals("IR")) {
            IdunsRegeneration.play(Variables.player1);
        } else if (player2 != null && player2.getAbbreviation().equals("IR")) {
            IdunsRegeneration.play(Variables.player2);
        }
    }

    private static void evalGodPower() {
        for (Item i : Variables.player1.getItems()) {
            if (i.hasGodpower()) {
                Variables.player1.setGodpower(Variables.player1.getGodpower() + 1);
            }
        }
        for (Item i : Variables.player2.getItems()) {
            if (i.hasGodpower()) {
                Variables.player2.setGodpower(Variables.player2.getGodpower() + 1);
            }
        }
    }

    private static void evalLifes() {
        if (Variables.player1.getLifes() != 0 && Variables.player2.getLifes() != 0) {
            String player1 = Variables.player1.getName() + ";" + Variables.player1.getLifes() + ";"
                    + Variables.player1.getGodpower();
            String player2 = Variables.player2.getName() + ";" + Variables.player2.getLifes() + ";"
                    + Variables.player2.getGodpower();
            Terminal.print(player1);
            Terminal.print(player2);
        } else if (Variables.player1.getLifes() == 0) {
            Terminal.print(Variables.player2.getName() + " wins");
            Variables.setRunning(false);
        } else if (Variables.player2.getLifes() == 0) {
            Terminal.print(Variables.player1.getName() + " wins");
            Variables.setRunning(false);
        }
    }

    private static void evalItems() {
        int p1meeleDmg = 0;
        int p1rangedDmg = 0;
        int p1blockedMeeleDmg = 0;
        int p1blockedRangedDmg = 0;
        int p2meeleDmg = 0;
        int p2rangedDmg = 0;
        int p2blockedMeeleDmg = 0;
        int p2blockedRangedDmg = 0;

        for (Item i : Variables.player1.getItems()) {
            if (i.getDamagetype() == Damagetype.MEELE_DAMAGE) {
                p1meeleDmg++;
            } else if (i.getDamagetype() == Damagetype.RANGED_DAMAGE) {
                p1rangedDmg++;
            } else if (i.getDamagetype() == Damagetype.BLOCK_MEELE_DAMAGE) {
                p1blockedMeeleDmg++;
            } else if (i.getDamagetype() == Damagetype.BLOCK_RANGED_DAMAGE) {
                p1blockedRangedDmg++;
            } else {
                Variables.player2.setGodpower(Variables.player2.getGodpower() - 1);
                Variables.player1.setGodpower(Variables.player1.getGodpower() + 1);
            }
        }
        for (Item i : Variables.player2.getItems()) {
            if (i.getDamagetype() == Damagetype.MEELE_DAMAGE) {
                p2meeleDmg++;
            } else if (i.getDamagetype() == Damagetype.RANGED_DAMAGE) {
                p2rangedDmg++;
            } else if (i.getDamagetype() == Damagetype.BLOCK_MEELE_DAMAGE) {
                p2blockedMeeleDmg++;
            } else if (i.getDamagetype() == Damagetype.BLOCK_RANGED_DAMAGE) {
                p2blockedRangedDmg++;
            } else {
                Variables.player1.setGodpower(Variables.player1.getGodpower() - 1);
                Variables.player2.setGodpower(Variables.player2.getGodpower() + 1);
            }
        }

        int p1TotalDmg = (p1meeleDmg - p2blockedMeeleDmg) + (p1rangedDmg - p2blockedRangedDmg);
        int p2TotalDmg = (p2meeleDmg - p1blockedMeeleDmg) + (p2rangedDmg - p1blockedRangedDmg);

        Variables.player1.setLifes(Variables.player1.getLifes() - p2TotalDmg);
        Variables.player2.setLifes(Variables.player2.getLifes() - p1TotalDmg);
    }

    private static void finishRound() {
        Variables.player1.getItems().clear();
        Variables.player2.getItems().clear();
        Main.coordinator.setCurrentPhase(Phase.DICE_PHASE);
        Main.coordinator.setCurrentPlayer(Variables.player1);
    }
}
