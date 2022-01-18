package edu.kit.informatik.game;

import edu.kit.informatik.game.godfavor.GodFavor;
import edu.kit.informatik.game.items.Damagetype;
import edu.kit.informatik.game.items.Item;
import edu.kit.informatik.messages.Errors;
import edu.kit.informatik.utils.Terminal;
import edu.kit.informatik.utils.Variables;

/**
 * This coordinator-object is managing the game.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class GameCoordinator {

    private static final int four = 4;
    private static final int six = 6;
    private static final int seven = 7;
    private static final int eight = 8;
    private static final int nine = 9;
    private static final int ten = 10;
    private static final int twelve = 12;

    private Player currentPlayer;
    private Phase currentPhase;

    /**
     * Gamecoordinator-object.
     * */
    public GameCoordinator() {
        this.currentPlayer = Variables.getPlayer1();
        this.currentPhase = Phase.DICE_PHASE;
    }

    /**
     * Adds all Items and godfavors.
     * */
    public void setup() {
        Variables.getItems().add(new Item("Axt", "MA", Damagetype.MEELE_DAMAGE, false));
        Variables.getItems().add(new Item("Helm", "MD", Damagetype.BLOCK_MEELE_DAMAGE, false));
        Variables.getItems().add(new Item("Götterkraft Helm", "GMD", Damagetype.BLOCK_MEELE_DAMAGE, true));
        Variables.getItems().add(new Item("Bogen", "RA", Damagetype.RANGED_DAMAGE, false));
        Variables.getItems().add(new Item("Götterkraft Bogen", "GRA", Damagetype.RANGED_DAMAGE, true));
        Variables.getItems().add(new Item("Schild", "RD", Damagetype.BLOCK_RANGED_DAMAGE, false));
        Variables.getItems().add(new Item("Götterkraft Schild", "GRD", Damagetype.BLOCK_RANGED_DAMAGE, true));
        Variables.getItems().add(new Item("Stehlen", "ST", Damagetype.NOTHING, false));
        Variables.getItems().add(new Item("Götterkraft Stehlen", "GST", Damagetype.NOTHING, true));

        Variables.getGodFavors().add(new GodFavor("Thor`s Blitz", "TS", 1, four, "2 Damage"));
        Variables.getGodFavors().add(new GodFavor("Thor`s Blitz", "TS", 2, eight, "5 Damage"));
        Variables.getGodFavors().add(new GodFavor("Thor`s Blitz", "TS", 3, twelve, "8 Damage"));
        Variables.getGodFavors().add(new GodFavor("Thrymr`s Diebstahl", "TT", 1, 3, "-1 godfavor level"));
        Variables.getGodFavors().add(new GodFavor("Thrymr`s Diebstahl", "TT", 2, six, "-2 godfavor level"));
        Variables.getGodFavors().add(new GodFavor("Thrymr`s Diebstahl", "TT", 3, nine, "-3 godfavor level"));
        Variables.getGodFavors().add(new GodFavor("Idun`s Regeneration", "IR", 1, four, "2 lifes"));
        Variables.getGodFavors().add(new GodFavor("Idun`s Regeneration", "IR", 2, seven, "4 lifes"));
        Variables.getGodFavors().add(new GodFavor("Idun`s Regeneration", "IR", 3, ten, "6 lifes"));
    }

    /**
     * Sets the player ready to play.
     *
     * @param input the values of the player (lifes, godpower, name)
     * */
    public void start(String input) {
        String[] args = input.split(";");
        Variables.getPlayer1().setName(args[0]);
        Variables.getPlayer2().setName(args[1]);
        if (args[2].matches("[0-9]*") ) {
            int lifes = Integer.parseInt(args[2]);
            if (lifes < 5) {
                Terminal.print(Errors.ERROR_LIFES_TO_LOW.toString());
                Variables.setRunning(false);
            }
            Variables.getPlayer1().setLifes(lifes);
            Variables.getPlayer2().setLifes(lifes);
        }
        if (args[3].matches("[0-9]*") ) {
            int godfavor = Integer.parseInt(args[3]);
            if (godfavor < 0) {
                Terminal.print(Errors.ERROR_GODPOWER_TO_LOW.toString());
                Variables.setRunning(false);
            }
            Variables.getPlayer1().setGodpower(godfavor);
            Variables.getPlayer2().setGodpower(godfavor);
        }

    }

    /**
     * Returns the current player.
     *
     * @return the current player
     * */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Returns the current phase.
     *
     * @return the current phase
     * */
    public Phase getCurrentPhase() {
        return currentPhase;
    }

    /**
     * Sets the current player.
     *
     * @param currentPlayer  the new player
     * */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Sets the current phase.
     *
     * @param currentPhase  the new player
     * */
    public void setCurrentPhase(Phase currentPhase) {
        this.currentPhase = currentPhase;
    }
}
