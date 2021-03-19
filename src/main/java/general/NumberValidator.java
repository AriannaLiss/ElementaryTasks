package general;

public abstract class NumberValidator {
    public abstract boolean isNumber(String arg);
    public abstract boolean isPositiveNumber(String arg);
    protected abstract Number parseNumber(String arg);

    public boolean isNumberInRange(String arg, double from, double to){
        if (isNumber(arg)){
            double n = parseNumber(arg).doubleValue();
            return (n >= from) && (n <= to);
        }
        return false;
    }
}
