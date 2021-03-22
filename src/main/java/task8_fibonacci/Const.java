package task8_fibonacci;

public interface Const {
    int LOW_BOUND = 0;
    int HIGH_BOUND = 1000000000;
    String RULES = "This application shows you fibonacci's row that fit to conditions:\n" +
            "1. Fibonacci's row with fixed numbers length (from 1 to 9).\n"+
            "   Example: 3\n"+
            "   Result:  [144, 233, 377, 610, 987]\n"+
            "2. Numbers are in the range (you should input positive 'from' 'to' numbers in a range [" +
            LOW_BOUND + ".." + HIGH_BOUND +"].\n" +
            "   Example: 20 2000\n" +
            "   Result:  [21, 34, 55, 89, 144, 233, 377, 610, 987, 1597]\n";

    String MODE = "Please, choose a mode 1 or 2 (0 for rules): ";
    String COUNT_OF_DIGITS = "Please, input count of digits for numbers in the Fibonacci's row (from 1 to 9): ";
    String FROM = "Please, input diapason for Fibonacci's row low bound: ";
    String TO = "Please, input diapason for Fibonacci's row high bound: ";
}
