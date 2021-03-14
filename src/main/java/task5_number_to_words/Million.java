package task5_number_to_words;

/**
 * shor scale
 */
public class Million {
    private static final String ILLION = "иллион";
    private static final String[] START_SYMBOLS = {"м","б","тр","квадр","квинт","секст","септ","окт","нон","дец"};
    private static final String[] START_OVER_36_POW ={"ун","дун","тре","кваттор","квин","секс","септ","окто","новем"};

    private static String getNameOfPosition(int thousandPower) {
        String nameOfPosition;
        if (thousandPower>21) throw new RuntimeException("Program works with numbers <= 10^66.");
        if (thousandPower < 12) {
            nameOfPosition = START_SYMBOLS[thousandPower - 2];
        }  else if (thousandPower == 21){
            nameOfPosition = "вигинт";
        } else {
            nameOfPosition = START_OVER_36_POW[thousandPower - 12] + START_SYMBOLS[START_SYMBOLS.length - 1];
        }
        return nameOfPosition + ILLION;
    }

    public static int getThousandInPower(long number, int thousandPower){
        return (int)(getRestOfThousandInPower(number,thousandPower+1) / Math.pow(1000,thousandPower));
    }
    //TODO BitInteger
    public static long getRestOfThousandInPower(long number, int thousandPower){
        return (long) (number % Math.pow(1000,thousandPower));
    }
    //TODO BigInteger
    public static String toString(long number) {
        String word = "";
        int thousandPower = 1;
        while ((int) (number / Math.pow(1000, thousandPower + 1)) != 0) {
            thousandPower++;
        }
        if (thousandPower == 1) return Thousand.toString(number);
        int thousand = getThousandInPower(number, thousandPower);
        if (thousand != 0) {
            word = Hundred.toString(thousand) + " " + getNameOfPosition(thousandPower);
            if (Decade.getDecadeDigit(thousand) == 1) {// || (Decade.getDecades(thousand) == 0)) {
                word += "ов";
            } else {
                int unit = Unit.getUnit(thousand);
                if (unit != 1) {
                    word += (unit < 5) && (unit != 0) ? "а" : "ов";
                }
            }
            if (getRestOfThousandInPower(number, thousandPower) == 0) return word;//?
            word += " ";
        }
        return word + Million.toString(getRestOfThousandInPower(number, thousandPower));
    }
}
