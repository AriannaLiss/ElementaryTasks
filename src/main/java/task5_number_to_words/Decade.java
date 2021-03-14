package task5_number_to_words;

public class Decade extends Unit{

    public static int getDecade(long number){
        return (int)((number % 100)/10);
    }
    public static String toString(long number){
        return toString(number,true);
    }
    public static String toString(long number, boolean printUnit){
        int decade = getDecade(number);
        String word="";
        switch(decade) {
            case 0:
                break;
            case 1:
                int unit = getUnit(number);
                switch(unit){
                    case 0: return "десять";
                    case 1: case 3: case 5: word = Unit.toString(unit); break;
                    case 2: word = "две"; break;
                    case 4: case 6: case 7: case 8: case 9:
                        word = Unit.toString(unit);
                        word = word.substring(0,word.length()-1);
                        break;
                }
                return word+"надцать";
            case 2: case 3:
                word = Unit.toString(decade)+"дцать";
                break;
            case 4:
                word = "сорок";
                break;
            case 9:
                word = "девяносто";
                break;
            default:
                word = Unit.toString(decade)+"десят";
                break;
        }
        return word+" "+Unit.toString(number);
    }
}
