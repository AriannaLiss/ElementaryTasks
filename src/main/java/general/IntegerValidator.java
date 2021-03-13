package general;

public class IntegerValidator extends Validator {

    public IntegerValidator(Dialog dialog) { super(dialog); }

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

    @Override
    public Integer getNotZeroPositiveNumber(String msg){
        return super.getNotZeroPositiveNumber(msg).intValue();
    }

    @Override
    public Integer getNumberInRange(String msg, double from, double to){
        return (Integer)super.getNumberInRange(msg,from,to);
    }
}
