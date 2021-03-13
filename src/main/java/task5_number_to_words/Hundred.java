package task5_number_to_words;

public class Hundred {
    public static String toString(int number){
        int unit = number % 1000 / 100;
        String word;
        switch(unit) {
            case 0:
                return Decade.toString(number);
            case 1:
                word = "сто";
                break;
            case 2:
                word = "двести";
                break;
            case 3:
                word = "триста";
                break;
            case 4:
                word = "четыреста";
                break;
            default:
                word = Unit.toString(unit)+"сот";
                break;
        }
        return word + " " + Decade.toString(number);
    }
}
