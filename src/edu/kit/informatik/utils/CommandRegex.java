package edu.kit.informatik.utils;

/**
 * Enumeration of command parameter regex.
 *
 * @author ubjrb
 * @version 1.0
 * */
public enum CommandRegex {

    /**
     * Command regex for the print-command.
     * */
    COMMAND_PRINT("print"),
    /**
     * Command regex for the roll-command.
     * */
    COMMAND_ROLL("roll (MA|MD|GMD|RA|GRA|RD|GRD|ST|GST);(MA|MD|GMD|RA|GRA|RD|GRD|ST|GST);" +
            "(MA|MD|GMD|RA|GRA|RD|GRD|ST|GST);(MA|MD|GMD|RA|GRA|RD|GRD|ST|GST);(MA|MD|GMD|RA|GRA|RD|GRD|ST|GST);" +
            "(MA|MD|GMD|RA|GRA|RD|GRD|ST|GST)"),
    /**
     * Command regex for the trun-command.
     * */
    COMMAND_TURN("trun"),
    /**
     * Command regex for the godfavor-command.
     * */
    COMMAND_GODFAVOR("godfavor (TS|TT|IR);([1-3])"),
    /**
     * Command regex for the evaluate-command.
     * */
    COMMAND_EVALUATE("evaluate"),
    /**
     * Command regex for the quit-command.
     * */
    COMMAND_QUIT("quit");

    private final String regex;

    /**
     * Creates an regex string for a command.
     *
     * @param regex the command
     * */
    CommandRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return regex;
    }
}
