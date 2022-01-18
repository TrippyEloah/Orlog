package edu.kit.informatik.game.godfavor.effects;

import edu.kit.informatik.game.Player;
import edu.kit.informatik.game.godfavor.GodFavor;
import edu.kit.informatik.utils.Variables;

/**
 * Class with the effect of the godfavor.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class ThorsLightning {

    private ThorsLightning() { }

    /**
     * Active abbility of the godfavor.
     *
     * @param owner the owner of the card
     * */
    public static void play(Player owner) {
        if (owner.getName().equals(Variables.player1.getName())) {
            GodFavor player1 = Variables.player1.getGodFavor();
            int damage = 2;
            if (player1.getLevel() == 2) {
                damage += 3;
            } else if (player1.getLevel() == 3) {
                damage += 6;
            }
            Variables.player2.setLifes(Variables.player2.getLifes() - damage);
            Variables.player1.setGodFavor(null);
            Variables.player1.setGodpower(Variables.player1.getGodpower() - (player1.getCosts()));
        } else {
            GodFavor player2 = Variables.player2.getGodFavor();
            int damage = 2;
            if (player2.getLevel() == 2) {
                damage += 3;
            } else if (player2.getLevel() == 3) {
                damage += 6;
            }
            Variables.player1.setLifes(Variables.player1.getLifes() - damage);

            Variables.player2.setGodFavor(null);
            Variables.player2.setGodpower(Variables.player2.getGodpower() - (player2.getCosts()));
        }

    }
}
