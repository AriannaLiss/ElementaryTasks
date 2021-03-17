package task5_number_to_words.number_to_words;

import java.math.BigInteger;

/**
 * Number in words
 * <p>
 * This application translates an integer number into words.
 * Example: 12 - двенадцать.
 * <p>
 * Program is run from main class with parameters.
 * <p>
 * !other classes in this package work only with not null positive numbers!
 */
public class NumberToWords implements Word {
    public static final String MINUS = "минус ";
    public static final String ZERO = "ноль";

    private BigInteger number;
    private int sign;

    public NumberToWords(BigInteger number) {
        sign = number.signum();
        if (sign < 0) {
            number = number.abs();
        }
        this.number = number;
    }

    public NumberToWords(long number) {
        this.number = BigInteger.valueOf(number);
    }

    public String toString(Sex sex) {
        StringBuilder numberByWords = new StringBuilder(EMPTY_STRING);
        if (sign < 0) {
            numberByWords.append(MINUS);
        } else if (number.signum() == 0) {
            return ZERO;
        }
        Millionaire millionaire = new Millionaire(number);
        return (numberByWords.append(millionaire.toString(sex))).toString();
    }

    @Override
    public String toString() {
        return toString(Sex.MALE);
    }
}
