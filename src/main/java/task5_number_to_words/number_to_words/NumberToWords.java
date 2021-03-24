package task5_number_to_words.number_to_words;

import java.math.BigInteger;

/**
 * Number to words
 *
 * This application translates an integer number into words.
 * Example: 12 - двенадцать.
 *
 * !other classes in this package work only with not zero positive numbers!
 */
public class NumberToWords{

    private final byte sign;
    private final short[] partsOfNumber;
    private byte lastRank;

    public NumberToWords(BigInteger number) {
        sign = (byte)number.signum();
        if (sign < 0) {
            number = number.abs();
        }
        partsOfNumber = divideNumberOnParts(number.toString());
    }

    public NumberToWords(long number) {
        this(BigInteger.valueOf(number));
    }

    @Override
    public String toString() {
        if (sign == 0) {
            return Word.ZERO;
        }
        StringBuilder numberByWords = new StringBuilder();
        if (sign < 0) {
            numberByWords.append(Word.MINUS);
        }
        for (byte rank = (byte)(partsOfNumber.length-1); rank>=lastRank; rank--){
            numberByWords.append(getPartOfNumberByWords(rank));
        }
        return numberByWords.toString();
    }

    private String getPartOfNumberByWords(byte rank){
        StringBuilder numberByWords = new StringBuilder();
        if (partsOfNumber[rank]!=0) {
            Hundred partNumberByWords = new Hundred(partsOfNumber[rank]);
            Number.Gender gender = (rank == 1) ? Number.Gender.FEMALE : Number.Gender.MALE;
            numberByWords.append(partNumberByWords.toString(gender));
            if (rank > 0) {
                numberByWords
                        .append(Word.SPACE)
                        .append(getRankName(rank))
                        .append(getEnd(partNumberByWords, rank));
                if (rank != lastRank) {
                    numberByWords.append(Word.SPACE);
                }
            }
        }
        return numberByWords.toString();
    }

    /**
     * This method returns triples of number.
     * The last part has index 0.
     * Example: if stringNumber = "400012" then output is [12, 400]
     *          if stringNumber = "10324" then output is [324, 10]
     * @param stringNumber String number, which will be divided on triples
     * @return array of triples (short)
     */
    private short[] divideNumberOnParts(String stringNumber) {
        byte numberLength = (byte) stringNumber.length();
        byte rank = (byte) Math.ceil(numberLength / 3.);
        short[] partsOfNumber = new short[rank];
        byte to = numberLength;
        byte from = to;
        lastRank = -1;
        for (byte i = 0; i < rank; i++) {
            from = (byte)((from < 3) ? 0 : from - 3);
            partsOfNumber[i]= Short.parseShort(stringNumber.substring(from, to));
            if ((lastRank == -1) && (partsOfNumber[i]!=0)) {
                lastRank = i;
            }
            to = from;
        }
        return partsOfNumber;
    }

    /**
     * short scale:
     * 10^3 thousand
     * 10^6 million
     * 10^9 billion
     * 10^12 trillion
     * ..
     * 10^63 vigintillion
     */
    private String getRankName(byte thousandPower) {
        if (thousandPower > 21) throw new OutOfBoundsNumberException();
        if (thousandPower == 1) return Word.THOUSANDS;
        String nameOfPosition;
        if (thousandPower < 12) {
            nameOfPosition = Word.START_SYMBOLS[thousandPower - 2];
        } else if (thousandPower == 21) {
            nameOfPosition = Word.VIGINT;
        } else {
            nameOfPosition = Word.START_OVER_36_POW[thousandPower - 12]
                    + Word.START_SYMBOLS[Word.START_SYMBOLS.length - 1];
        }
        return nameOfPosition + Word.ILLION;
    }

    /**
     * @param hundred part number for this rank
     * @param rank > 0
     * @return String end for thousand and millions
     */
    private String getEnd(Hundred hundred, byte rank){
        if (rank==1) return getThousandEnd(hundred);
        return getMillionEnd(hundred);
    }

    private String getMillionEnd(Hundred hundred) {
        byte unit = hundred.getUnit();
        if ((hundred.getDecadeFigure() == 1) || (unit >= 5) || (unit == 0)) {
            return (Word._OV);
        } else if (unit >= 2) {
            return (Word._A);
        }
        return Word.EMPTY_STRING; //unit == 1
    }

    private String getThousandEnd(Hundred hundred){
        byte decade = hundred.getDecadeFigure();
        if (decade!=1) {
            byte unit = hundred.getUnit();
            if (unit == 1) {
                return Word._A;
            } else if ((unit > 1) && (unit < 5)) {
                return Word._I;
            }
        }
        return Word.EMPTY_STRING;
    }
}
