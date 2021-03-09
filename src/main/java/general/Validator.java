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

    public static boolean isGreaterZero(double value) {
        return (value > 0);
    }
}
