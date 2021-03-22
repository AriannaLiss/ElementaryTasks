package general;

public abstract class NumberValidator {
    public boolean isNumber(String arg){
        return arg.matches("\\s*-?\\d+\\s*");
    }

    public boolean isPositiveNumber(String arg){
        return !(arg.matches("\\s*-.*"))&&isNumber(arg);
    }

    protected abstract Number parseNumber(String arg);

    public boolean isNumberInRange(String arg, double from, double to){
        if (isNumber(arg)){
            double n = parseNumber(arg).doubleValue();
            return (n >= from) && (n <= to);
        }
        return false;
    }
}
