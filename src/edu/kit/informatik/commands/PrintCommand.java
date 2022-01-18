package edu.kit.informatik.commands;

import edu.kit.informatik.utils.Terminal;
import edu.kit.informatik.utils.Variables;

/**
 * Commend witch prints the players.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class PrintCommand {

    /**
     * Creats an instance for a print-command.
     * */
    public PrintCommand() { }

    /**
     * Prints the players.
     * */
    public void print() {
        String player1 = Variables.player1.getName() + ";" + Variables.player1.getLifes() + ";"
                + Variables.player1.getGodpower();
        String player2 = Variables.player2.getName() + ";" + Variables.player2.getLifes() + ";"
                + Variables.player2.getGodpower();
        Terminal.print(player1);
        Terminal.print(player2);
    }
}
