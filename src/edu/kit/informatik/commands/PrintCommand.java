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
        String player1 = Variables.getPlayer1().getName() + ";" + Variables.getPlayer1().getLifes() + ";"
                + Variables.getPlayer1().getGodpower();
        String player2 = Variables.getPlayer2().getName() + ";" + Variables.getPlayer2().getLifes() + ";"
                + Variables.getPlayer2().getGodpower();
        Terminal.print(player1);
        Terminal.print(player2);
    }
}
