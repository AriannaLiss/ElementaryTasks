package general;

public abstract class Dialog {
    public abstract String getLine();
    public abstract void print(String msg);

    public double getDouble(){
        return getDouble(ConstGeneral.PLEASE_INPUT_FLOAT);
    }

    public double getDouble(String msg){
        String data;
        do {
            print(msg);
            data = getLine();
            if (!NumberValidator.isDouble(data)){
                print(ConstGeneral.NOT_VALID_DATA);
            }
            else{
                return Double.parseDouble(data);
            }
        }
        while(true);
    }

    public double getNotZeroPositiveDouble(String msg){
        double number;
        do{
            number = getDouble(msg);
            if (number<=0) {
                print(ConstGeneral.NOT_VALID_DATA);
            }
            else {
                return number;
            }
        }
        while(true);
    }

    public int getInt(){
        return getInt(ConstGeneral.PLEASE_INPUT_INT);
    }

    public int getInt(String msg){
        String data;
        do {
            print(msg);
            data = getLine();
            if (!NumberValidator.isInt(data)){
                print(ConstGeneral.NOT_VALID_DATA);
            }
            else{
                return Integer.parseInt(data);
            }
        }
        while(true);
    }

    public boolean yesNo(){
        return yesNo(ConstGeneral.YES_NO);
    }

    public boolean yesNo(String msg) {
        String answer;
        print(msg);
        answer = getLine();
        return ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("yes")));
    }
}
