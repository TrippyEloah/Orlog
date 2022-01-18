package edu.kit.informatik.game.godfavor.effects;

import edu.kit.informatik.game.Player;
import edu.kit.informatik.game.godfavor.GodFavor;
import edu.kit.informatik.utils.Terminal;
import edu.kit.informatik.utils.Variables;

/**
 * Class with the effect of the godfavor.
 *
 * @author ubjrb
 * @version 1.0
 * */
public final class IdunsRegeneration {

    private IdunsRegeneration() { }

    private static final int four = 4;
    private static final int two = 2;

    /**
     * Active abbility of the godfavor.
     *
     * @param owner the owner of the card
     * */
    public static void play(Player owner) {
        if (owner.getName().equals(Variables.getPlayer1().getName())) {
            GodFavor player1 = Variables.getPlayer1().getGodFavor();

            if (Variables.getPlayer1().getLifes() != 0) {
                int heal = two;
                if (player1.getLevel() == 2) {
                    heal += two;
                } else if (player1.getLevel() == 3) {
                    heal += four;
                }
                Variables.getPlayer1().setLifes(Variables.getPlayer1().getLifes() + heal);
            } else {
                Terminal.print(Variables.getPlayer2().getName() + " wins");
                Variables.setRunning(false);
            }
            Variables.getPlayer1().setGodFavor(null);
            Variables.getPlayer1().setGodpower(Variables.getPlayer1().getGodpower() - (player1.getCosts()));
        } else {
            GodFavor player2 = Variables.getPlayer2().getGodFavor();

            if (Variables.getPlayer2().getLifes() != 0) {
                int heal = two;
                if (player2.getLevel() == 2) {
                    heal += two;
                } else if (player2.getLevel() == 3) {
                    heal += four;
                }
                Variables.getPlayer2().setLifes(Variables.getPlayer1().getLifes() + heal);
            } else {
                Terminal.print(Variables.getPlayer1().getName() + " wins");
                Variables.setRunning(false);
            }

            Variables.getPlayer2().setGodFavor(null);
            Variables.getPlayer2().setGodpower(Variables.getPlayer2().getGodpower() - (player2.getCosts()));
        }

    }

}


