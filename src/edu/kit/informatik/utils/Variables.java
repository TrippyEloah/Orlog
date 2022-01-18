package edu.kit.informatik.utils;

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
    private static Player player1 = new Player("dummy1", 0, 0, new ArrayList<Item>());
    /**
     * The second player as a dummy, filled with the real values after start.
     * */
    private static Player player2 = new Player("dumm2", 0, 0, new ArrayList<Item>());

    /**
     * List of all items.
     * */
    private static ArrayList<Item> items = new ArrayList<Item>();

    /**
     * List of all godfavors.
     * */
    private static ArrayList<GodFavor> godFavors = new ArrayList<GodFavor>();

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

    /**
     * Returns player1.
     *
     * @return player1
     * */
    public static Player getPlayer1() {
        return player1;
    }

    /**
     * Returns player2.
     *
     * @return player2
     * */
    public static Player getPlayer2() {
        return player2;
    }

    /**
     * Returns the list with all items.
     *
     * @return items
     * */
    public static ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Returns the list with all favors.
     *
     * @return godfavor
     * */
    public static ArrayList<GodFavor> getGodFavors() {
        return godFavors;
    }
}
