package general;

public class NumberValidator {
    //not null
    public static boolean isDouble(String arg){
        return arg.matches("\\s*-?\\d+(\\.\\d+)?\\s*");
    }

    //not null
    public static boolean isInt(String arg){
        return arg.matches("\\s*-?\\d+\\s*");
    }

    //could be equal zero
    public static boolean isPositiveInt(String arg){
        return arg.matches("\\s*\\d+\\s*");
    }

    //return true if param is integer and fits to range [from..to]
    public static boolean isIntInRange(String param, int from, int to){
        if(isInt(param))
        {
            int value = Integer.parseInt(param);
            return (value >= from)&&(value <= to);
        }
        return false;
    }
}
