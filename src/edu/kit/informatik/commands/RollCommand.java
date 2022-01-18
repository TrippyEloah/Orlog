package edu.kit.informatik.commands;

import edu.kit.informatik.game.Phase;
import edu.kit.informatik.game.items.Item;
import edu.kit.informatik.main.Main;
import edu.kit.informatik.messages.Errors;
import edu.kit.informatik.utils.Terminal;
import edu.kit.informatik.utils.Variables;

/**
 * Command witch rolls the dice.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class RollCommand {

    private final String dice;

    /**
     * Creats an object to roll the dice.
     *
     * @param dice the given dice
     * */
    public RollCommand(String dice) {
        this.dice = dice;
    }

    /**
     * Simulates the roll of the dice.
     * */
    public void roll() {
        if (Main.coordinator.getCurrentPhase() == Phase.DICE_PHASE) {
            String[] raw = this.dice.split(" ");
            String[] abbreviation = splitDice(raw[1]);

            for (String s : abbreviation) {
                for (Item i : Variables.items) {
                    if (s.equals(i.getAbbreviation())) {
                        Main.coordinator.getCurrentPlayer().getItems().add(i);
                    }
                }
            }
            Terminal.print("OK");
        } else {
            Terminal.print(Errors.ERROR_CANT_ROLL_JET.toString());
        }
    }

    private static String[] splitDice(String dice) {
        return dice.split(";");
    }
}
