package task5_number_to_words;

public class Unit {

    public static int getUnit(long number){
        return (int)(number % 10);
    }

    public static String toString(long number){
        return toString(number,true);
    }
    public static String toString(long number, boolean printUnit){
        String word="";
        if (printUnit) {
            int unit = getUnit(number);
            switch (unit) {
                case 0:
                    word = (number != 0) ? "" : "ноль";
                    break;
                case 1:
                    word = "один";
                    break;
                case 2:
                    word = "два";
                    break;
                case 3:
                    word = "три";
                    break;
                case 4:
                    word = "четыре";
                    break;
                case 5:
                    word = "пять";
                    break;
                case 6:
                    word = "шесть";
                    break;
                case 7:
                    word = "семь";
                    break;
                case 8:
                    word = "восемь";
                    break;
                case 9:
                    word = "девять";
                    break;
            }
        }
        return word;
    }
}
