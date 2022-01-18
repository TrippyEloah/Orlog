package edu.kit.informatik.utils;

import edu.kit.informatik.game.Phase;
import edu.kit.informatik.game.Player;
import edu.kit.informatik.game.godfavor.GodFavor;
import edu.kit.informatik.game.items.Item;

import java.util.ArrayList;

/**
 * This class equals an hodgepodge for varialbles.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class Variables {

    /**
     * Private Constructor, so there is one.
     * */
    private Variables() { }

    /**
     * The first player as a dummy, filled with the real values after start.
     * */
    public static Player player1 = new Player("dummy1", 0, 0, new ArrayList<Item>());
    /**
     * The second player as a dummy, filled with the real values after start.
     * */
    public static Player player2 = new Player("dumm2", 0, 0, new ArrayList<Item>());

    /**
     * List of all items.
     * */
    public static ArrayList<Item> items = new ArrayList<Item>();

    /**
     * List of all godfavors.
     * */
    public static ArrayList<GodFavor> godFavors = new ArrayList<GodFavor>();

    private static boolean running = true;

    /**
     * Gets the running boolean witch shows if the game is still running
     *
     * @return running, witch indicates the gamestatus
     * */
    public static boolean isRunning() {
        return running;
    }

    /**
     * Changes the gamestatus
     *
     * @param running the new gamestatus
     * */
    public static void setRunning(boolean running) {
        Variables.running = running;
    }

}
