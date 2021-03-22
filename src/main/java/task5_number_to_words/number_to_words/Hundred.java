package task5_number_to_words.number_to_words;

public class Hundred extends Number {
    private static final int RATE = 100;
    private static final String HUNDRED = "сто";
    private static final String TWO_HUNDRED = "двести";
    private static final String _STA = "ста";
    private static final String _SOT = "сот";

    Hundred(int number) {
        super(number, RATE);
    }

    @Override
    public String toString(Sex sex) {
        int hundred = getRateDigit();
        StringBuilder word = new StringBuilder(EMPTY_STRING);
        if (hundred > 0) {
            switch(hundred) {
                case 1:
                    word.append(HUNDRED);
                    break;
                case 2:
                    word.append(TWO_HUNDRED);
                    break;
                default:
                    word.append(new Unit(hundred));
                    if ((hundred == 3) || (hundred == 4)) {
                        word.append(_STA);
                    } else {
                        word.append(_SOT);
                    }
            }
        }
        return combineWords(word, new Decade(getDecades()).toString(sex));
    }
}
