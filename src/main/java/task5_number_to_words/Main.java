package task5_number_to_words;

import general.ConsoleInputOutput;

/**
 * Number in words
 *
 * This application translates an integer number into words.
 * Example: 12 - двенадцать.
 *
 * Program is run from main class with parameters.
 */

public class Main {
    public static void main(String[] args) {
            new Application(new ConsoleInputOutput()).run(args);
    }
}
