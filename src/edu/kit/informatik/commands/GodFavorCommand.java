package edu.kit.informatik.commands;

import edu.kit.informatik.game.Phase;
import edu.kit.informatik.game.godfavor.GodFavor;
import edu.kit.informatik.main.Main;
import edu.kit.informatik.messages.Errors;
import edu.kit.informatik.utils.Terminal;
import edu.kit.informatik.utils.Variables;

/**
 * Command picks the godfavor.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class GodFavorCommand {

    private String command;

    /**
     * Creats an object wtich picks a godfavor.
     *
     * @param command the command given
     * */
    public GodFavorCommand(String command) {
        this.command = command;
    }

    /**
     * Picks a godfavor.
     * */
    public void pick() {
        String name = getGodfavor(command);
        int level = getLevel(command);
        if (Main.coordinator.getCurrentPhase() == Phase.GODFAVOR_PHASE) {
            if (Main.coordinator.getCurrentPlayer().getGodFavor() == null) {
                Main.coordinator.getCurrentPlayer().setGodFavor(findGodfavor(name, level));
                Terminal.print("OK");
            } else {
                Terminal.print(Errors.ERROR_ALLREADY_PICKED.toString());
            }
        } else {
            Terminal.print(Errors.ERROR_CANT_PICK_GODFAVOR.toString());
        }
    }

    private static String getGodfavor(String command) {
        String[] args = command.split(" ");
        String[] values = args[1].split(";");

        return values[0];
    }

    private static int getLevel(String command) {
        String[] args = command.split(" ");
        String[] values = args[1].split(";");

        return Integer.parseInt(values[1]);
    }

    private static GodFavor findGodfavor(String name, int level) {
        for (GodFavor favor : Variables.godFavors) {
            if (name.equals(favor.getAbbreviation())) {
                if (level == favor.getLevel()) {
                    return favor;
                }
            }
        }
        return null;
    }
}
