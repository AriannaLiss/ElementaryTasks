package general;

public abstract class NumberValidator {
    public abstract boolean isNumber(String arg);
    public abstract Number parseNumber(String arg);

    //could be equal zero
    public boolean isNotNullPositiveNumber(String arg){
        if(isNumber(arg)){
            if (parseNumber(arg)>0){
                return true;
            }
        }
        return false;
    }

    //return true if arg is valid and fits to range [from..to]
    public boolean isNumberInRange(String arg, Double from, Double to){
        if(isNumber(arg))
        {
            Number value = parseNumber(arg);
            return (value >= from)&&(value <= to);
        }
        return false;
    }
}
