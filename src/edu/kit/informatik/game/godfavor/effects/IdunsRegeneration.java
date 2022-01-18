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
public class IdunsRegeneration {

    private IdunsRegeneration() { }

    /**
     * Active abbility of the godfavor.
     *
     * @param owner the owner of the card
     * */
    public static void play(Player owner) {
        if (owner.getName().equals(Variables.player1.getName())) {
            GodFavor player1 = Variables.player1.getGodFavor();

            if (Variables.player1.getLifes() != 0) {
                int heal = 2;
                if (player1.getLevel() == 2) {
                    heal += 2;
                } else if (player1.getLevel() == 3) {
                    heal += 4;
                }
                Variables.player1.setLifes(Variables.player1.getLifes() + heal);
            } else {
                Terminal.print(Variables.player2.getName() + " wins");
                Variables.setRunning(false);
            }
            Variables.player1.setGodFavor(null);
            Variables.player1.setGodpower(Variables.player1.getGodpower() - (player1.getCosts()));
        } else {
            GodFavor player2 = Variables.player2.getGodFavor();

            if (Variables.player2.getLifes() != 0) {
                int heal = 2;
                if (player2.getLevel() == 2) {
                    heal += 2;
                } else if (player2.getLevel() == 3) {
                    heal += 4;
                }
                Variables.player2.setLifes(Variables.player1.getLifes() + heal);
            } else {
                Terminal.print(Variables.player1.getName() + " wins");
                Variables.setRunning(false);
            }

            Variables.player2.setGodFavor(null);
            Variables.player2.setGodpower(Variables.player2.getGodpower() - (player2.getCosts()));
        }

    }

}


