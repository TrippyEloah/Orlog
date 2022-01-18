package edu.kit.informatik.main;

import edu.kit.informatik.commands.GodFavorCommand;
import edu.kit.informatik.commands.PrintCommand;
import edu.kit.informatik.commands.RollCommand;
import edu.kit.informatik.commands.TurnCommand;
import edu.kit.informatik.commands.EvaluateCommand;
import edu.kit.informatik.game.GameCoordinator;
import edu.kit.informatik.messages.Errors;
import edu.kit.informatik.utils.CommandRegex;
import edu.kit.informatik.utils.Terminal;
import edu.kit.informatik.utils.Variables;

/**
 * Main Ui for the Orlog game.
 *
 * @author ubjrb
 * @version 1.0
 * */
public final class Main {

    /**
     * Private constructor, so the Main-Object can´t be accesed.
     * */
    private Main() { }

    private static final PrintCommand PRINTCOMMAND = new PrintCommand();
    private static final TurnCommand TURNCOMMAND = new TurnCommand();
    /**
     * Creats an coordinator of the game.
     * */
    private static final GameCoordinator coordinator = new GameCoordinator();

    public static void main(String[] args) {
        coordinator.setup();
        coordinator.start(args[0]);

        while (Variables.isRunning()) {
            final String input = Terminal.readLine();

            if (input.matches(CommandRegex.COMMAND_QUIT.toString())) {
                Variables.setRunning(false);
            } else if (input.matches(CommandRegex.COMMAND_PRINT.toString())) {
                PRINTCOMMAND.print();
            } else if (input.matches(CommandRegex.COMMAND_ROLL.toString())) {
                RollCommand rollCommand = new RollCommand(input);
                rollCommand.roll();
            } else if (input.matches(CommandRegex.COMMAND_EVALUATE.toString())) {
                EvaluateCommand evaluateCommand = new EvaluateCommand();
                evaluateCommand.evaluate();
            } else if (input.matches(CommandRegex.COMMAND_TURN.toString())) {
                TURNCOMMAND.turn();
            } else if (input.matches(CommandRegex.COMMAND_GODFAVOR.toString())) {
                GodFavorCommand godFavorCommand = new GodFavorCommand(input);
                godFavorCommand.pick();
            } else {
                Terminal.print(Errors.ERROR_UNKONWN_COMMAND.toString());
                Variables.setRunning(false);
            }
        }
    }

    /**
     * Gets the coordinator.
     *
     * @return coordinator
     * */
    public static GameCoordinator getCoordinator() {
        return coordinator;
    }
}


