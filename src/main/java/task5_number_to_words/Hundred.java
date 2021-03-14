package task5_number_to_words;

public class Hundred extends Decade{

    public static int getHundred(long number){
        return (int)((number % 1000)/100);
    }
    public static String toString(long number){
        return toString(number,true);
    }

    public static String toString(long number, boolean printUnit){
        int unit = getHundred(number);
        String word;
        switch(unit) {
            case 0:
                return Decade.toString(number);//prunit
            case 1:
                word = "сто";
                break;
            case 2:
                word = "двести";
                break;
            case 3: case 4:
                word = Unit.toString(unit)+"ста";
                break;
            default:
                word = Unit.toString(unit)+"сот";
                break;
        }
        return word + " " + Decade.toString(number);
    }
}
