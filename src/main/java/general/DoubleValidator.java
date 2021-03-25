package general;

public class DoubleValidator extends NumberValidator {
    @Override
    public boolean isNumber(String arg) {
        return arg.matches("\\s*[-+]?\\d+(\\.\\d+)?\\s*");
    }

    @Override
    protected Double parseNumber(String arg) {
        return Double.parseDouble(arg);
    }

}
