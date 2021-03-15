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
public class Millionaires {
    private static final String ILLION = "иллион";
    private static final String[] START_SYMBOLS = {"м","б","тр","квадр","квинт","секст","септ","окт","нон","дец"};
    private static final String[] START_OVER_36_POW ={"ун","дуо","тре","кваттор","квин","секс","септ","окто","новем"};

    private static String getNameOfPosition(int thousandPower) {
        String nameOfPosition;
        if (thousandPower>21) throw new RuntimeException("Application works with numbers < 10^66.\n");
        if (thousandPower < 12) {
            nameOfPosition = START_SYMBOLS[thousandPower - 2];
        }  else if (thousandPower == 21){
            nameOfPosition = "вигинт";
        } else {
            nameOfPosition = START_OVER_36_POW[thousandPower - 12] + START_SYMBOLS[START_SYMBOLS.length - 1];
        }
        return nameOfPosition + ILLION;
    }

    public static int getThousandInPower(BigInteger number, int thousandPower){
        return getRestOfThousandInPower(number,thousandPower+1).divide(thousandPow(thousandPower)).intValue();
    }

    public static BigInteger getRestOfThousandInPower(BigInteger number, int thousandPower){
        return number.remainder(thousandPow(thousandPower));
    }
    public static BigInteger thousandPow(int thousandPower){
        return BigInteger.TEN.pow(thousandPower*3);
    }

    public static String toString(BigInteger number) {
        String word = "";
        int thousandPower = 1;
        while (number.compareTo(thousandPow(thousandPower + 1)) >= 0) {//?
            thousandPower++;
        }
        if (thousandPower == 1) return Thousand.toString(number.longValue());
        int thousand = getThousandInPower(number, thousandPower);
        if (thousand != 0) {
            word = Hundred.toString(thousand) + " " + getNameOfPosition(thousandPower);
            if (Decade.getDecadeDigit(thousand) == 1) {
                word += "ов";
            } else {
                int unit = Unit.getUnit(thousand);
                if (unit != 1) {
                    word += (unit < 5) && (unit != 0) ? "а" : "ов";
                }
            }
            if (getRestOfThousandInPower(number, thousandPower).signum() == 0) return word;//?
            word += " ";
        }
        return word + Millionaires.toString(getRestOfThousandInPower(number, thousandPower));
    }
}
