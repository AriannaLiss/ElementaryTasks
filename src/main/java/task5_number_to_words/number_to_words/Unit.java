package task5_number_to_words.number_to_words;

class Unit extends Number{
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

    Unit(short number){
        super(number);
    }

    @Override
    public String toString(Gender gender){
        String word = Word.EMPTY_STRING;
        switch (getUnit()) {
            case 0:
                word = Word.EMPTY_STRING;
                break;
            case 1:
                word = (gender == Gender.FEMALE) ? ONE_FEM : ONE;
                break;
            case 2:
                word = (gender == Gender.FEMALE) ? TWO_FEM : TWO;
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
