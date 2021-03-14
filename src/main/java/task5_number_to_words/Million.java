package task5_number_to_words;

public class Million extends Thousand{
    public static String toString(long number){
        return toString(number,true);
    }
    public static String toString(long number, boolean printUnit){
        int million = getThousandInPower(number,2);
        String word = Thousand.toString(million,true);
        if (getDecade(million)!=1) {
            int unit = getUnit(million);
            switch (unit) {
                case 1:
                    word += "миллион";
                    break;
                case 2: case 3: case 4:
                    word += "миллиона";
                    break;
                default:
                    word += " миллионов";
                    break;
            }
        } else {
            word += " миллионов";
        }
        return word + " " + Thousand.toString(number);
    }
}
