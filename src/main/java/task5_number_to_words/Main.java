package task5_number_to_words;

import general.ConsoleDialog;
import general.Dialog;

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
        Dialog dialog = new ConsoleDialog();
        new Application(dialog).run(args);
        new Test(dialog).run();
    }
}
