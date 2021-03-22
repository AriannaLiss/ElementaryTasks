package general;

public class Dialog{
    private NumberValidator validator;
    private InputOutput io;

    public Dialog(InputOutput inputOutput, NumberValidator validator){
        this.io = inputOutput;
        this.validator = validator;
    }

    public String getLine(){
        return io.getLine();
    }

    public void print(String msg){
        io.print(msg);
    }

    public Number getNumber(String msg){
       return validator.parseNumber(getStringNumber(msg));
    }

    //getNumber without parsing
    public String getStringNumber(String msg){
        String data;
        do {
            io.print(msg);
            data = io.getLine();
            if (!validator.isNumber(data)){
                io.print(ConstGeneral.NOT_VALID_DATA);
            }
            else{
                return data;
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
                io.print(ConstGeneral.NOT_VALID_DATA);
            }
            else{
                return n;
            }
        }while(true);
    }

    public boolean yesNo(String msg) {
        String answer;
        io.print(msg);
        answer = io.getLine().trim();
        return ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("yes")));
    }

    public boolean yesNo(){
        return yesNo(ConstGeneral.YES_NO);
    }
}
