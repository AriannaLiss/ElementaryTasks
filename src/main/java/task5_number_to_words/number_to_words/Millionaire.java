package task5_number_to_words.number_to_words;

import java.math.BigInteger;

/**
 * short scale:
 * 10^6 million
 * 10^9 billion
 * 10^12 trillion
 * ..
 * 10^63 vigintillion
 */
public class Millionaire implements Word {
    private static final String ILLION = "иллион";
    private static final String[] START_SYMBOLS = {
            "м", "б", "тр", "квадр", "квинт", "секст", "септ", "окт", "нон", "дец"
    };
    private static final String[] START_OVER_36_POW = {
            "ун", "дуо", "тре", "кваттор", "квин", "секс", "септ", "окто", "новем"
    };
    private static final String VIGINT = "вигинт";
    private static final String _OV = "ов";
    private BigInteger number;

    Millionaire(BigInteger number) {
        this.number = number;
    }

    private String getNameOfPosition(int thousandPower) {
        String nameOfPosition;
        if (thousandPower > 21) throw new OutOfBoundsNumberException();
        if (thousandPower < 12) {
            nameOfPosition = START_SYMBOLS[thousandPower - 2];
        } else if (thousandPower == 21) {
            nameOfPosition = VIGINT;
        } else {
            nameOfPosition = START_OVER_36_POW[thousandPower - 12]
                            + START_SYMBOLS[START_SYMBOLS.length - 1];
        }
        return nameOfPosition + ILLION;
    }

    private BigInteger thousandPow(int thousandPower) {
        return BigInteger.TEN.pow(thousandPower * 3);
    }

    private int getThousandInPower(BigInteger number, int thousandPower) {
        return getRestOfThousandInPower(number, thousandPower + 1)
                .divide(thousandPow(thousandPower)).intValue();
    }

    private BigInteger getRestOfThousandInPower(BigInteger number, int thousandPower) {
        return number.remainder(thousandPow(thousandPower));
    }

    private int getExponent() {
        int thousandPower = 1;
        while (number.compareTo(thousandPow(thousandPower + 1)) >= 0) {
            thousandPower++;
        }
        return thousandPower;
    }

    private String getEnd(Hundred hundreds) {
        int unit = hundreds.getUnit();
        if ((hundreds.getDecadeFigure() == 1) || (unit >= 5) || (unit == 0)) {
            return (_OV);
        } else if (unit >= 2) {
            return (_A);
        }
        return EMPTY_STRING; //unit == 1
    }

    private String millionToString(int thousandPower) {
        int countOfMillions = getThousandInPower(number, thousandPower);
        if (countOfMillions > 0) {
            Hundred hundreds = new Hundred(countOfMillions);
            return hundreds + SPACE + getNameOfPosition(thousandPower) + getEnd(hundreds);
        }
        return EMPTY_STRING;
    }

    @Override
    public String toString(Sex sex) {
        String word = EMPTY_STRING;
        for (int thousandPower = getExponent(); thousandPower > 1; thousandPower--) {
            word = combineWords(word, millionToString(thousandPower));
        }
        int thousands = getRestOfThousandInPower(number, 2).intValue();
        if (thousands == 0) {
            return word;
        }
        return combineWords(word, new Thousand(thousands).toString(sex));
    }

    @Override
    public String toString() {
        return toString(Number.Sex.MALE);
    }
}
