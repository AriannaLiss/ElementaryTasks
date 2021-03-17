package task5_number_to_words.number_to_words;

/**
 * works with int numbers under 1000000
 */
public class Thousand extends Number{
    private static final int RATE = 1000;
    private static final String THOUSANDS = " тысяч";
    private static final String _I = "и";

    Thousand(int number){
        super(number,RATE);
    }

    private int getThousandAmount(){
        return getThousands()/RATE;
    }

    @Override
    public String toString (Sex sex) {
        int thousand = getThousandAmount();
        StringBuilder word = new StringBuilder(EMPTY_STRING);
        if (thousand != 0) {
            word
                    .append(new Hundred(thousand).toString(Sex.FEMALE))
                    .append(THOUSANDS)
                    .append(getEnd(thousand));
        }
        return combineWords(word, new Hundred(getHundreds()).toString(sex));
    }

    private String getEnd(int thousand){
        int decade = getDecadeFigure(thousand);
        if (decade!=1) {
            int unit = getUnit(thousand);
            if (unit == 1) {
                return _A;
            } else if ((unit > 1) && (unit < 5)) {
                return _I;
            }
        }
        return EMPTY_STRING;
    }
}