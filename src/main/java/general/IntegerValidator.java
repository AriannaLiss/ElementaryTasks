package general;

public class IntegerValidator extends NumberValidator {

    @Override
    public boolean isNumber(String arg){
        return arg.matches("\\s*-?\\d+\\s*");
    }

    @Override
    public boolean isPositiveNumber(String arg){
        return arg.matches("\\s*\\d+\\s*");
    }

    //could be exception if not integer
    @Override
    protected Integer parseNumber(String arg) { return Integer.parseInt(arg); }
}
