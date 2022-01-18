package edu.kit.informatik.game;


import edu.kit.informatik.game.godfavor.GodFavor;
import edu.kit.informatik.game.items.Item;

import java.util.ArrayList;

/**
 * This class equals an game-object with the neccesary informations for playing.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class Player {

    private String name;
    private int godpower;
    private int lifes;
    private ArrayList<Item> items;
    private GodFavor godFavor;

    /**
     * Creats an player object.
     *
     * @param name the name of the player
     * @param godpower the amount of godpower points the player has
     * @param items the current items they rolled
     * @param lifes the amount of lifes left
     * */
    public Player(String name, int godpower, int lifes, ArrayList<Item> items) {
        this.name = name;
        this.godpower = godpower;
        this.lifes = lifes;
        this.items = items;
        this.godFavor = null;
    }

    /**
     * Gets the name of the player
     *
     * @return the name of the player
     * */
    public String getName() {
        return name;
    }

    /**
     * Retruns the items the player has this turn.
     *
     * @return the items the player has this trun
     * */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Returns the godpower points the player has.
     *
     * @return the godpower points the player own
     * */
    public int getGodpower() {
        return godpower;
    }

    /**
     * Retruns the lifes left for the player.
     *
     * @return the current amount of lifes
     * */
    public int getLifes() {
        return lifes;
    }

    /**
     * Sets the godpower.
     *
     * @param godpower the new amount of points
     * */
    public void setGodpower(int godpower) {
        this.godpower = godpower;
    }

    /**
     * Sets the new items
     *
     * @param items the new rolled items
     * */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * sets the amount of lifes left.
     *
     * @param lifes the lifes left
     * */
    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    /**
     * Substract the given amount of lifes.
     *
     * @param amount the amount to subtract
     * */
    public void substractLifes(int amount) {
        this.lifes -= amount;
    }

    /**
     * Sets the name of the player
     *
     * @param name the new name of the player
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the godFavor.
     *
     * @param godFavor the new godfavor
     * */
    public void setGodFavor(GodFavor godFavor) {
        this.godFavor = godFavor;
    }

    /**
     * Returns the current godfavor.
     *
     * @return godfavor
     * */
    public GodFavor getGodFavor() {
        return godFavor;
    }
}

