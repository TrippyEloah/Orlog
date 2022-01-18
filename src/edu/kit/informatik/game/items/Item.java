package edu.kit.informatik.game.items;

/**
 * Creats the basic object of an item.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class Item {

    private final String name;
    private final String abbreviation;
    private final Damagetype damagetype;
    private final boolean hasGodpower;

    /**
     *Creats an item-object for the items
     *
     * @param name the name of the item
     * @param abbreviation the shortend name of the item
     * @param damagetype the type of damage the item deals
     * @param hasGodpower shows if the card has a godpowerpoint
     * */
    public Item(String name, String abbreviation, Damagetype damagetype, boolean hasGodpower) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.damagetype = damagetype;
        this.hasGodpower = hasGodpower;
    }

    /**
     * Returns the damagetype the item deals.
     *
     * @return the damagetype the item deals
     * */
    public Damagetype getDamagetype() {
        return damagetype;
    }

    /**
     * Returns the abbreviation of the item.
     *
     * @return the abbreviation of the item
     * */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     * */
    public String getName() {
        return name;
    }

    /**
     * Returns true if the item has a godpower.
     *
     * @return returns true if the item has a godpower
     * */
    public boolean hasGodpower() {
        return hasGodpower;
    }
}
