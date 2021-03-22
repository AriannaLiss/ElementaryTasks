package task5_number_to_words.number_to_words;

public class Unit extends Number{
    private static final String ONE = "один";
    private static final String ONE_FEM = "одна";
    private static final String TWO = "два";
    private static final String TWO_FEM = "две";
    private static final String THREE = "три";
    private static final String FOUR = "четыре";
    private static final String FIVE = "пять";
    private static final String SIX = "шесть";
    private static final String SEVEN = "семь";
    private static final String EIGHT = "восемь";
    private static final String NINE = "девять";

    Unit(int number){
        super(number,1);
    }

    @Override
    public String toString(Sex sex){
        String word=EMPTY_STRING;
        switch (getUnit()) {
            case 0:
                word = EMPTY_STRING;
                break;
            case 1:
                word = (sex==Sex.FEMALE) ? ONE_FEM : ONE;
                break;
            case 2:
                word = (sex==Sex.FEMALE) ? TWO_FEM : TWO;
                break;
            case 3:
                word = THREE;
                break;
            case 4:
                word = FOUR;
                break;
            case 5:
                word = FIVE;
                break;
            case 6:
                word = SIX;
                break;
            case 7:
                word = SEVEN;
                break;
            case 8:
                word = EIGHT;
                break;
            case 9:
                word = NINE;
                break;
        }
        return word;
    }
}
