package general;

public class Validator {
    //not null
    public static boolean isDouble(String arg){
        return arg.matches("-?\\d+(\\.\\d+)?");
    }

    //not null
    public static boolean isInt(String arg){
        return arg.matches("-?\\d+");
    }

    //could be equal zero
    public static boolean isPositiveInt(String arg){
        return arg.matches("\\d+");
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
