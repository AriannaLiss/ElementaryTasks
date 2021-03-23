package task5_number_to_words.number_to_words;

class Decade extends Number {
    private static final String TEN = "десять";
    private static final String FORTY = "сорок";
    private static final String NINETY = "девяносто";

    private static final String DVE_ = "две";
    private static final String _NADTSAT = "надцать";
    private static final String _DTSAT = "дцать";
    private static final String _DESYAT = "десят";

    Decade(short number) {
        super(number);
    }

    @Override
    public String toString(Gender gender) {
        StringBuilder word = new StringBuilder(Word.EMPTY_STRING);
        byte decade = getDecadeFigure();
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
        return combineWords(word, new Unit(getUnit()).toString(gender));
    }

    /**
     * @return number in diapason [10..19] by words
     */
    private String toStringDecades() {
        StringBuilder word = new StringBuilder(Word.EMPTY_STRING);
        byte unit = getUnit();
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
