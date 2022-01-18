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
public final class ThorsLightning {

    private ThorsLightning() { }

    private static final int six = 6;

    /**
     * Active abbility of the godfavor.
     *
     * @param owner the owner of the card
     * */
    public static void play(Player owner) {
        if (owner.getName().equals(Variables.getPlayer1().getName())) {
            GodFavor player1 = Variables.getPlayer1().getGodFavor();

            int damage = 2;
            if (player1.getLevel() == 2) {
                damage += 3;
            } else if (player1.getLevel() == 3) {
                damage += six;
            }
            int newLife = Variables.getPlayer2().getLifes() - damage;

            Variables.getPlayer2().setLifes(newLife);
            Variables.getPlayer1().setGodFavor(null);
            Variables.getPlayer1().setGodpower(Variables.getPlayer1().getGodpower() - (player1.getCosts()));
        } else {
            GodFavor player2 = Variables.getPlayer2().getGodFavor();
            int damage = 2;
            if (player2.getLevel() == 2) {
                damage += 3;
            } else if (player2.getLevel() == 3) {
                damage += six;
            }
            int newLife = Variables.getPlayer1().getLifes() - damage;

            Variables.getPlayer1().setLifes(newLife);
            Variables.getPlayer2().setGodFavor(null);
            Variables.getPlayer2().setGodpower(Variables.getPlayer2().getGodpower() - (player2.getCosts()));
        }

    }
}
