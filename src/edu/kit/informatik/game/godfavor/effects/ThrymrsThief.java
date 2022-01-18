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
public class ThrymrsThief {

    private ThrymrsThief() { }

    /**
     * Active abbility of the godfavor.
     *
     * @param owner the owner of the card
     * */
    public static void play(Player owner) {
        if (owner.getName().equals(Variables.player1.getName())) {
            GodFavor player1 = Variables.player1.getGodFavor();
            if (Variables.player2.getGodFavor() != null) {
                GodFavor help = Variables.player2.getGodFavor();
                int lvl = help.getLevel() - player1.getLevel();
                if (lvl != 0) {
                    for (GodFavor f : Variables.godFavors) {
                        if (f.getName().equals(help.getName()) && f.getLevel() == lvl) {
                            Variables.player2.setGodFavor(f);
                        }
                    }
                } else {
                    Variables.player2.setGodFavor(null);
                }
            }
            Variables.player1.setGodFavor(null);
            Variables.player1.setGodpower(Variables.player1.getGodpower() - (player1.getCosts()));
        } else {
            GodFavor player2 = Variables.player2.getGodFavor();
            if (Variables.player1.getGodFavor() != null) {
                GodFavor help = Variables.player1.getGodFavor();
                int lvl = help.getLevel() - player2.getLevel();
                if (lvl != 0) {
                    for (GodFavor f : Variables.godFavors) {
                        if (f.getName().equals(help.getName()) && f.getLevel() == lvl) {
                            Variables.player1.setGodFavor(f);
                        }
                    }
                } else {
                    Variables.player1.setGodFavor(null);
                }
            }
            Variables.player2.setGodFavor(null);
            Variables.player2.setGodpower(Variables.player2.getGodpower() - (player2.getCosts()));
        }
    }
}
