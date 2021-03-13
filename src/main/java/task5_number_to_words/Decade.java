package task5_number_to_words;

public class Decade {
    public static String toString(int number){
        int decade = number % 100 / 10;
        String word="";
        switch(decade) {
            case 0:
                return Unit.toString(number);
            case 1:
                int unit = number%10;
                switch(unit){
                    case 0: return "десять";
                    case 1: case 3: case 5: word = Unit.toString(unit); break;
                    case 2: word = "две"; break; //TODO female thouthands
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
