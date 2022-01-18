package edu.kit.informatik.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A Terminal to print and read things.
 * @author ubjrb
 * @version 1.0
 * */
public final class Terminal {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Private constructor so there is one.
     */
    private Terminal() { }

    /**
     * Reads a line input in the console.
     *
     * @return the content of the line
     * */
    public static String readLine() {
        String read = "";
        try {
            read = reader.readLine();
        } catch (IOException e) {
            print(e.toString());
        }
        return read;
    }

    /**
     * Prints a line into the console.
     *
     * @param print input witch will be printed
     * */
    public static void print(String print) {
        System.out.println(print);
    }

    /**
     * Splits a String at " ".
     *
     * @param command the command to split
     * @return String array with the values
     * */
    public static String[] extractValues(String command) {
        return command.split(" ");
    }


}