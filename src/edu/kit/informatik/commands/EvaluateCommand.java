package edu.kit.informatik.commands;

import edu.kit.informatik.game.godfavor.GodFavor;
import edu.kit.informatik.game.godfavor.effects.IdunsRegeneration;
import edu.kit.informatik.game.godfavor.effects.ThorsLightning;
import edu.kit.informatik.game.godfavor.effects.ThrymrsThief;
import edu.kit.informatik.game.items.Damagetype;
import edu.kit.informatik.game.items.Item;
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
        evalGodPower();
        evalGodFavor();
        evalItems();
        evalLifes();

        Variables.getPlayer1().getItems().clear();
        Variables.getPlayer2().getItems().clear();
        Variables.getPlayer1().setGodFavor(null);
        Variables.getPlayer2().setGodFavor(null);
    }

    private static void evalGodFavor() {
        GodFavor player1 = Variables.getPlayer1().getGodFavor();
        GodFavor player2 = Variables.getPlayer2().getGodFavor();

        if (player1 != null && player1.getAbbreviation().equals("TT")) {
            if (Variables.getPlayer1().getGodpower() >= player1.getCosts()) ThrymrsThief.play(Variables.getPlayer1());
        } else if (player2 != null && player2.getName().equals("TT")) {
            if (Variables.getPlayer2().getGodpower() >= player2.getCosts()) ThrymrsThief.play(Variables.getPlayer1());
        } else if (player1 != null && player1.getAbbreviation().equals("TS")) {
            if (Variables.getPlayer1().getGodpower() >= player1.getCosts()) ThorsLightning.play(Variables.getPlayer1());
        } else if (player2 != null && player2.getAbbreviation().equals("TS")) {
            if (Variables.getPlayer2().getGodpower() >= player2.getCosts()) ThorsLightning.play(Variables.getPlayer2());
        } else if (player1 != null && player1.getAbbreviation().equals("IR")) {
            if (Variables.getPlayer1().getGodpower() >= player1.getCosts()) IdunsRegeneration.play(Variables.getPlayer1());
        } else if (player2 != null && player2.getAbbreviation().equals("IR")) {
            if (Variables.getPlayer2().getGodpower() >= player2.getCosts()) IdunsRegeneration.play(Variables.getPlayer2());
        }
    }

    private static void evalGodPower() {
        for (Item i : Variables.getPlayer1().getItems()) {
            if (i.hasGodpower()) {
                Variables.getPlayer1().setGodpower(Variables.getPlayer1().getGodpower() + 1);
            }
        }
        for (Item i : Variables.getPlayer2().getItems()) {
            if (i.hasGodpower()) {
                Variables.getPlayer2().setGodpower(Variables.getPlayer2().getGodpower() + 1);
            }
        }
    }

    private static void evalLifes() {
        if (Variables.getPlayer1().getLifes() != 0 && Variables.getPlayer2().getLifes() != 0) {
            String player1 = Variables.getPlayer1().getName() + ";" + Variables.getPlayer1().getLifes() + ";"
                    + Variables.getPlayer1().getGodpower();
            String player2 = Variables.getPlayer2().getName() + ";" + Variables.getPlayer2().getLifes() + ";"
                    + Variables.getPlayer2().getGodpower();
            Terminal.print(player1);
            Terminal.print(player2);
        } else if (Variables.getPlayer1().getLifes() == 0) {
            Terminal.print(Variables.getPlayer2().getName() + " wins");
        } else if (Variables.getPlayer2().getLifes() == 0) {
            Terminal.print(Variables.getPlayer1().getName() + " wins");
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

        for (Item i : Variables.getPlayer1().getItems()) {
            if (i.getDamagetype() == Damagetype.MEELE_DAMAGE) {
                p1meeleDmg++;
            } else if (i.getDamagetype() == Damagetype.RANGED_DAMAGE) {
                p1rangedDmg++;
            } else if (i.getDamagetype() == Damagetype.BLOCK_MEELE_DAMAGE) {
                p1blockedMeeleDmg++;
            } else if (i.getDamagetype() == Damagetype.BLOCK_RANGED_DAMAGE) {
                p1blockedRangedDmg++;
            } else {
                if (Variables.getPlayer2().getGodpower() >= 1) {
                    Variables.getPlayer2().setGodpower(Variables.getPlayer2().getGodpower() - 1);
                    Variables.getPlayer1().setGodpower(Variables.getPlayer1().getGodpower() + 1);
                }
            }
        }
        for (Item i : Variables.getPlayer2().getItems()) {
            if (i.getDamagetype() == Damagetype.MEELE_DAMAGE) {
                p2meeleDmg++;
            } else if (i.getDamagetype() == Damagetype.RANGED_DAMAGE) {
                p2rangedDmg++;
            } else if (i.getDamagetype() == Damagetype.BLOCK_MEELE_DAMAGE) {
                p2blockedMeeleDmg++;
            } else if (i.getDamagetype() == Damagetype.BLOCK_RANGED_DAMAGE) {
                p2blockedRangedDmg++;
            } else {
                if (Variables.getPlayer1().getGodpower() >= 1) {
                    Variables.getPlayer1().setGodpower(Variables.getPlayer1().getGodpower() - 1);
                    Variables.getPlayer2().setGodpower(Variables.getPlayer2().getGodpower() + 1);
                }
            }
        }
        int p2TotalDmg = 0;
        int p1TotalDmg = 0;

        if (p1meeleDmg > p2blockedMeeleDmg) p1TotalDmg += (p1meeleDmg - p2blockedMeeleDmg);
        if (p1rangedDmg > p2blockedRangedDmg) p1TotalDmg += (p1rangedDmg - p2blockedRangedDmg);
        if (p2meeleDmg > p1blockedMeeleDmg) p2TotalDmg += (p2meeleDmg - p1blockedMeeleDmg);
        if (p2rangedDmg > p1blockedRangedDmg) p2TotalDmg += (p2rangedDmg - p1blockedRangedDmg);

        int newLifesP1 = Variables.getPlayer1().getLifes() - p2TotalDmg;
        int newLifesP2 = Variables.getPlayer2().getLifes() - p1TotalDmg;

        Variables.getPlayer1().setLifes(newLifesP1);
        Variables.getPlayer2().setLifes(newLifesP2);
    }
}
