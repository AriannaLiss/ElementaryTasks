package task5_number_to_words;

public class Thousand {
    public static String toString(int number){
        int thousand = number % 1000000 / 1000;
        String word = Unit.toString(thousand);
        switch(thousand) {
            case 0:
                return Hundred.toString(number);
            case 1:
                word = "одна тысяча";
                break;
            case 2:
                word = "две тысячи";
                break;
            case 3: case 4:
            word += " тысячи";
                break;
            default:
                word += " тысяч";
                break;
        }
        return word + " " + Hundred.toString(number);
    }
}
