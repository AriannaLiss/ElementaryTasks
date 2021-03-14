package task5_number_to_words;

public class Thousand {

    public static String toString(long number) {
        int thousand = Million.getThousandInPower(number, 1);
        String word = "";
        if (thousand != 0) {
            word = Hundred.toString(thousand);
            if (Decade.getDecadeDigit(thousand) == 1) {// || (thousand % 100 == 0)) {
                word += " тысяч";
            } else {
                int unit = Unit.getUnit(thousand);
                if ((unit == 1) || (unit == 2)) {
                    word = word.substring(0, word.length() - 2);
                }
                switch (unit) {
                    case 1:
                        word += "на тысяча";
                        break;
                    case 2:
                        word += "ве";
                    default:
                        word += (unit < 5) && (unit != 0) ? " тысячи" : " тысяч";
                }

            }
            if (Hundred.getHundreds(number) != 0) {
                word += " ";
            }
        }
        return word + Hundred.toString(number);
    }
}
