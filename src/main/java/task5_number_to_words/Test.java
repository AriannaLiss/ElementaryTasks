package task5_number_to_words;

import general.ConstGeneral;
import general.Dialog;
import task5_number_to_words.number_to_words.NumberToWords;
import task5_number_to_words.number_to_words.Word;

import java.math.BigInteger;
import java.util.Random;

public class Test {

    private static final int MAX_POW = 66;
    private static final String RANDOM_BIG_NUMBERS = "\nRandom big numbers:\n";
    private static final String BOUNDS_VALUES = "\nBounds values:\n";
    private final BigInteger BIG_NUMBER = new BigInteger("-4056064506500005062000545005064");
    private final BigInteger MINUS_ONE = BigInteger.valueOf(-1l);
    private final long[] test = {
            -395, 0, 9879, -0, 100000, -440260, 350650, 321105, -711123,
            10324, 0232, 601052, 132004, 400012, 100000000, 50288241, 96105619
    };

    private Dialog dialog;

    Test(Dialog dialog) {
        this.dialog = dialog;
    }

    public void run() {
        testArray();
        testArray(Word.Sex.FEMALE);
        testString(BIG_NUMBER);
        boundsTesting();
        testRandomBigNumbers();
    }

    private int randomFigure(Random random){
        if (random.nextBoolean())
            return random.nextInt(10);
        return 0;
    }

    private void boundsTesting(){
        dialog.print(BOUNDS_VALUES);
        final BigInteger MAX_VALUE = BigInteger.TEN.pow(MAX_POW).subtract(BigInteger.ONE);
        testString(MAX_VALUE);
        try {
            testString(MAX_VALUE.add(BigInteger.ONE));
        } catch (Exception e) {
            dialog.print(e.getMessage());
        }
        testString(MAX_VALUE.multiply(MINUS_ONE));
    }

    private void testArray(Word.Sex sex){
        dialog.print(ConstGeneral.NEW_LINE + sex.toString() + ConstGeneral.NEW_LINE);
        for (long n : test) {
            testString(BigInteger.valueOf(n),sex);
        }
    }

    private void testArray(){
        testArray(Word.Sex.MALE);
    }

    private void testRandomBigNumbers(){
        dialog.print(RANDOM_BIG_NUMBERS);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            StringBuilder n = new StringBuilder(ConstGeneral.EMPTY_STRING);
            int countOfDigits = random.nextInt(MAX_POW);
            for (int j = 1; j < countOfDigits+1; j++) {
                n.append(randomFigure(random));
            }
            testString(new BigInteger(n.toString()));
        }
    }

    private void testString(BigInteger n, Word.Sex sex) {
        dialog.print(n + ConstGeneral.DASH + new NumberToWords(n).toString(sex) + ConstGeneral.NEW_LINE);
    }

    private void testString(BigInteger n) {
        testString(n, Word.Sex.MALE);
    }
}
