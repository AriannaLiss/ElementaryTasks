package task8_fibonacci;

import general.ConsoleDialog;

/**
 * Show all Fibonacci's numbers, that fit to condition:
 * numbers are in the range (you should input positive 'from' 'to' numbers in a range [0..2147483647]);
 * Fibonacci's row with fixed length numbers (from 1 to 9);
 */
public class Main {

    public static void main(String... args){
        Application task8 = new Application(new ConsoleDialog());
        task8.run(args);
    }
}
