package task5_number_to_words.number_to_words;

public class Hundred {

    public static int getHundredDigit(long number){
        return getHundreds(number)/100;
    }

    public static int getHundreds(long number){
        return (int)(number % 1000);
    }

    public static String toString(long number){
        int hundred = getHundredDigit(number);
        String word = "";
        if (hundred>0) {
            switch (hundred) {
                case 1:
                    word = "сто";
                    break;
                case 2:
                    word = "двести";
                    break;
                default:
                    word = Unit.toString(hundred);
                    if ((hundred == 3) || (hundred == 4)) {
                        word += "ста";
                    } else {
                        word += "сот";
                    }
            }
            if (Decade.getDecades(number) != 0) {
                word += " ";
            }
        }
        return word + Decade.toString(number);
    }
}
