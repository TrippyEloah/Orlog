package edu.kit.informatik.commands;

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
        if (Main.getCoordinator().getCurrentPlayer() == Variables.getPlayer2()) {
            Terminal.print(Variables.getPlayer1().getName());
            Main.getCoordinator().setCurrentPlayer(Variables.getPlayer1());
            nextPhase();
        } else {
            Terminal.print(Variables.getPlayer2().getName());
            Main.getCoordinator().setCurrentPlayer(Variables.getPlayer2());
        }

    }

    private static void nextPhase() {
        if (Main.getCoordinator().getCurrentPhase() == Phase.DICE_PHASE) {
            Main.getCoordinator().setCurrentPhase(Phase.GODFAVOR_PHASE);
        } else {
            Main.getCoordinator().setCurrentPhase(Phase.DICE_PHASE);
        }
    }
}
