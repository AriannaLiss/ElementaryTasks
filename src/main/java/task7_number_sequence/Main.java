package task7_number_sequence;

import general.ConsoleInputOutput;

/**
 * Number sequence.
 *
 * This application returns you a natural number sequence separated by comma.
 * Parameters: two natural numbers: n m
 * Where:      n is a length of the sequence
 *             m is a minimal square for numbers in the sequence.
 * Output:     the sequence with n natural numbers (theirs square are not less m).
 */
public class Main {

    public static void main(String... args){
        Application task7 = new Application(new ConsoleInputOutput());
        task7.run(args);
    }
}
