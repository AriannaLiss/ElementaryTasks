package task8_fibonacci;

public interface Const {
    int LOW_BOUND = 0;
    int HIGH_BOUND = 1000000000;
    String RULES = "This application shows you fibonacci's row that fit to conditions:\n" +
            "1. Numbers are in the range (you should input positive 'from' 'to' numbers in a range [" +
            LOW_BOUND + ".." + HIGH_BOUND +"].\n" +
            "   Example: java main 20 2000\n" +
            "   Result:  [21, 34, 55, 89, 144, 233, 377, 610, 987, 1597]\n"+
            "2. Fibonacci's row with fixed length numbers (from 1 to 9).\n"+
            "   Example: java main 3\n"+
            "   Result:  [144, 233, 377, 610, 987]\n";
}
