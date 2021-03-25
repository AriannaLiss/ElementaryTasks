package general;

public class IntegerValidator extends NumberValidator {
    @Override
    protected Integer parseNumber(String arg) {
        return Integer.parseInt(arg);
    }
}
