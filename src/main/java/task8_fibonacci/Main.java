package task8_fibonacci;

import general.ConsoleInputOutput;

/**
 * Show all Fibonacci's numbers, that fit to condition:
 * numbers are in the range (you should input positive 'from' 'to' numbers in a range [0..2147483647]);
 * Fibonacci's row with fixed length numbers (from 1 to 9);
 */
public class Main {

    public static void main(String... args){
        Task8Application task8 = new Task8Application(new ConsoleInputOutput());
        task8.run();
    }
}
