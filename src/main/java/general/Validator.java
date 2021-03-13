package general;

public abstract class Validator {
    private Dialog dialog;
    public abstract boolean isNumber(String arg);
    public abstract boolean isPositiveNumber(String arg);
    protected abstract Number parseNumber(String arg);

    Validator(Dialog dialog){
        this.dialog = dialog;
    }

    public Number getNumber(String msg){
        String data;
        do {
            dialog.print(msg);
            data = dialog.getLine();
            if (!isNumber(data)){
                dialog.print(ConstGeneral.NOT_VALID_DATA);
            }
            else{
                return parseNumber(data);
            }
        }
        while(true);
    }

    public Number getNumberInRange(String msg, double from, double to){
        do{
            double n = getNumber(msg).doubleValue();
            if ((n >= from)&&(n <= to)){
                return n;
            }
        }
        while(true);
    }

    public Number getNotZeroPositiveNumber(String msg){
        do {
            Number n = getNumber(msg);
            if (n.doubleValue() <= 0) {
                dialog.print(ConstGeneral.NOT_VALID_DATA);
            }
            else{
                return n;
            }
        }while(true);
    }

    public boolean isNumberInRange(String arg, double from, double to){
        if (isNumber(arg)){
            double n = parseNumber(arg).doubleValue();
            return (n >= from) && (n <= to);
        }
        return false;
    }

    public boolean yesNo(String msg) {
        String answer;
        dialog.print(msg);
        answer = dialog.getLine().trim();
        return ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("yes")));
    }

    public boolean yesNo(){
        return yesNo(ConstGeneral.YES_NO);
    }
}
