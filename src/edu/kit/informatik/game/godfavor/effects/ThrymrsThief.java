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
public final class ThrymrsThief {

    private ThrymrsThief() { }

    /**
     * Active abbility of the godfavor.
     *
     * @param owner the owner of the card
     * */
    public static void play(Player owner) {
        if (owner.getName().equals(Variables.getPlayer1().getName())) {
            GodFavor player1 = Variables.getPlayer1().getGodFavor();
            if (Variables.getPlayer2().getGodFavor() != null) {
                GodFavor help = Variables.getPlayer2().getGodFavor();
                int lvl = help.getLevel() - player1.getLevel();
                Variables.getPlayer2().setGodFavor(findGodFavor(help, lvl));
            } else {
                Variables.getPlayer2().setGodFavor(null);
            }
            Variables.getPlayer1().setGodFavor(null);
            Variables.getPlayer1().setGodpower(Variables.getPlayer1().getGodpower() - (player1.getCosts()));
        } else {
            GodFavor player2 = Variables.getPlayer2().getGodFavor();
            if (Variables.getPlayer1().getGodFavor() != null) {
                GodFavor help = Variables.getPlayer1().getGodFavor();
                int lvl = help.getLevel() - player2.getLevel();
                Variables.getPlayer1().setGodFavor(findGodFavor(help, lvl));
            } else {
                Variables.getPlayer1().setGodFavor(null);
            }

            Variables.getPlayer2().setGodFavor(null);
            Variables.getPlayer2().setGodpower(Variables.getPlayer2().getGodpower() - (player2.getCosts()));
        }
    }

    private static GodFavor findGodFavor(GodFavor help, int lvl) {
        if (lvl != 0) {
            for (GodFavor f : Variables.getGodFavors()) {
                if (f.getName().equals(help.getName()) && f.getLevel() == lvl) {
                    return f;
                }
            }
        }
        return null;
    }
}
