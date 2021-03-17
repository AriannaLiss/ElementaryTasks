package task5_number_to_words.number_to_words;

public class Decade extends Number {
    private static final int RATE = 10;
    private static final String TEN = "десять";
    private static final String FORTY = "сорок";
    private static final String NINETY = "девяносто";

    private static final String DVE_ = "две";
    private static final String _NADTSAT = "надцать";
    private static final String _DTSAT = "дцать";
    private static final String _DESYAT = "десят";

    Decade(int number) {
        super(number, RATE);
    }

    @Override
    public String toString(Sex sex) {
        StringBuilder word = new StringBuilder(EMPTY_STRING);
        int decade = getRateDigit();
        if (decade != 0) {
            if (decade > 0) {
                switch (decade) {
                    case 1:
                        return toStringDecades();
                    case 4:
                        word.append(FORTY);
                        break;
                    case 9:
                        word.append(NINETY);
                        break;
                    default:
                        word.append(new Unit(decade));
                        if (decade < 5) {
                            word.append(_DTSAT);
                        } else {
                            word.append(_DESYAT);
                        }
                }
            }
        }
        return combineWords(word, new Unit(getUnit()).toString(sex));
    }

    private String toStringDecades() {
        StringBuilder word = new StringBuilder(EMPTY_STRING);
        int unit = getUnit();
        switch (unit) {
            case 0:
                return TEN;
            case 2:
                word.append(DVE_);
                break;
            default:
                word.append(new Unit(unit));
                if (unit >= 4) {
                    word.deleteCharAt(word.length() - 1);
                }
        }
        return word.append(_NADTSAT).toString();
    }
}
