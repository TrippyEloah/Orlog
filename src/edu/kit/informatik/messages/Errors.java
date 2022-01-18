package edu.kit.informatik.messages;

/**
 * Enumeration of Error-Messages.
 *
 * @author ubjrb
 * @version 1.0
 * */
public enum Errors {

    /**
     * Specific error, for invalid parameter.
     * */
    ERROR_UNKONWN_COMMAND("unkonwn commmand, game quits."),
    /**
     * Specific error, for initial life to low.
     * */
    ERROR_LIFES_TO_LOW("the amount of lifes given is to low, game will not start."),
    /**
     * Specific error, for initial godpower to low.
     * */
    ERROR_GODPOWER_TO_LOW("the amount of godpower given is to low, game will not start."),
    /**
     * Specific error, cant roll in this phase.
     * */
    ERROR_CANT_ROLL_JET("you can only roll in the dice-phase."),
    /**
     * Specific error, cant pick a godfavor right now.
     * */
    ERROR_CANT_PICK_GODFAVOR("you can only pick a godfavor in the godfavor-phase."),
    /**
     * Specific error, allready picked a godfavor.
     * */
    ERROR_ALLREADY_PICKED("you can only pick one godfavor."),
    /**
     * Specific error, cant evaluate right now.
     * */
    ERROR_CANT_EVALUATE("the evaluation is only available in the execution-phase."),
    /**
     * Specific error, not enough Godpower to play.
     * */
    ERROR_CARD_COSTS_TO_MUCH("you cant afford the godfavor.");


    private final String error;

    /**
     * Creates an new Error, with a message.
     *
     * @param error reason for the error
     * */
    Errors(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Error, " + error;
    }


}
