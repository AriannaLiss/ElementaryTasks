package task5_number_to_words;

public class Thousand extends Hundred{
    public static String toString(long number){
        return toString(number,true);
    }

    public static int getThousandInPower(long number, int thousandPower){
        return (int)((number % Math.pow(1000,thousandPower+1) / Math.pow(1000,thousandPower)));
    }

    public static String toString(long number){
        int thousand = getThousandInPower(number,1);
        String word = Hundred.toString(thousand,false);
        if (getDecade(thousand)==1) {
            word += " тысяч";
        }
        else{
            int unit = getUnit(thousand);
            switch (unit) {
                case 1:
                    word += "одна тысяча";
                    break;
                case 2:
                    word += "две тысячи";
                    break;
                case 3:
                case 4:
                    word += Unit.toString(unit) + " тысячи";
                    break;
                default:
                    word += Unit.toString(unit) + " тысяч";
                    break;
            }
        }
        return word + " " + Hundred.toString(number);
    }
}
