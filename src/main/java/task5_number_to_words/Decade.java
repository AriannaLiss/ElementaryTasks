package task5_number_to_words;

public class Decade {

    public static int getDecadeDigit(long number){
        return getDecades(number)/10;
    }

    public static int getDecades(long number){
        return (int)(number % 100);
    }

    public static String toString(long number){
        int decade = getDecadeDigit(number);
        String word="";
        if (decade>0) {
            switch (decade) {
                case 1:
                    int unit = Unit.getUnit(number);
                    switch (unit) {
                        case 0:
                            return "десять";
                        case 2:
                            word = "две";
                            break;
                        default:
                            word = Unit.toString(unit);
                            if (unit >= 4) {
                                word = word.substring(0, word.length() - 1);
                            }
                    }
                    return word + "надцать";
                case 4:
                    word = "сорок";
                    break;
                case 9:
                    word = "девяносто";
                    break;
                default:
                    word = Unit.toString(decade);
                    word += (decade < 5) ? "дцать" : "десят";
            }
            if (Unit.getUnit(number)!=0) {
                word += " ";
            }
        }
        return word+Unit.toString(number);
    }
}
