package edu.kit.informatik.commands;

import edu.kit.informatik.game.GameCoordinator;
import edu.kit.informatik.game.Phase;
import edu.kit.informatik.main.Main;
import edu.kit.informatik.utils.Terminal;
import edu.kit.informatik.utils.Variables;

/**
 * Commend witch prints the players.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class TurnCommand {

    /**
     * Creats an turn-command-object.
     * */
    public TurnCommand() { }

    /**
     * Implements a turn command.
     * */
    public void turn() {
        if (Main.coordinator.getCurrentPlayer() == Variables.player2) {
            Terminal.print(Variables.player1.getName());
            Main.coordinator.setCurrentPlayer(Variables.player1);
            nextPhase();
        } else {
            Terminal.print(Variables.player2.getName());
            Main.coordinator.setCurrentPlayer(Variables.player2);
        }

    }

    private static void nextPhase() {
        if (Main.coordinator.getCurrentPhase() == Phase.DICE_PHASE) {
            Main.coordinator.setCurrentPhase(Phase.GODFAVOR_PHASE);
        } else if (Main.coordinator.getCurrentPhase() == Phase.GODFAVOR_PHASE) {
            Main.coordinator.setCurrentPhase(Phase.EXECUTE_PHASE);
        } else {
            Main.coordinator.setCurrentPhase(Phase.DICE_PHASE);
        }
    }
}
