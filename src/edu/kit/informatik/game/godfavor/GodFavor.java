package edu.kit.informatik.game.godfavor;

/**
 * This class equals an godfavor-object with the neccesary informations for playing.
 *
 * @author ubjrb
 * @version 1.0
 * */
public class GodFavor {

    private final String name;
    private final String abbreviation;
    private final int level;
    private final int costs;
    private final String effect;

    /**
     * Creats an object for the godflavors.
     *  @param name the name of the flavor
     * @param abbreviation the abbreviation of the favor
     * @param level the level of the flavor
     * @param costs the costs of the flavor
     * @param effect the effect of the flavor
     * */
    public GodFavor(String name, String abbreviation, int level, int costs, String effect) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.level = level;
        this.costs = costs;
        this.effect = effect;
    }

    /**
     * Returns the name.
     *
     * @return name the name
     * */
    public String getName() {
        return name;
    }

    /**
     * Retruns the costs.
     *
     * @return costs the costs.
     * */
    public int getCosts() {
        return costs;
    }

    /**
     * Returns the level.
     *
     * @return level the level.
     * */
    public int getLevel() {
        return level;
    }

    /**
     * Returns the abbreviation.
     *
     * @return abbreviation of the favor
     * */
    public String getAbbreviation() {
        return abbreviation;
    }
}
