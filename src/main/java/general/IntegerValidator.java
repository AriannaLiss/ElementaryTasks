package general;

public class IntegerValidator extends NumberValidator {
    //could be exception if not integer
    @Override
    protected Integer parseNumber(String arg) { return Integer.parseInt(arg); }
}
