package task5_number_to_words;

import general.ConsoleDialog;

/**
 * Number in words
 *
 * This application translate an integer number into words.
 * Example: 12 - двенадцать.
 *
 * Program is run from main class with parameters.
 */

public class Main {
    public static void main(String[] args) {
        new Application(new ConsoleDialog()).run(args);
    }
}
