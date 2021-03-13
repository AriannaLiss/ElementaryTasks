package general;

public class DoubleValidator extends Validator {

    public DoubleValidator(Dialog dialog) { super(dialog); }

    @Override
    public boolean isNumber (String arg){
        return arg.matches("\\s*-?\\d+(\\.\\d+)?\\s*");
    }

    @Override
    public boolean isPositiveNumber (String arg){
        return arg.matches("\\s*\\d+(\\.\\d+)?\\s*");
    }

    //could be exception
    @Override
    protected Double parseNumber(String arg) { return Double.parseDouble(arg); }

    @Override
    public Double getNotZeroPositiveNumber(String msg){
        return super.getNotZeroPositiveNumber(msg).doubleValue();
    }

    @Override
    public Double getNumberInRange(String msg, double from, double to){
        return (Double)super.getNumberInRange(msg,from,to);
    }
}
