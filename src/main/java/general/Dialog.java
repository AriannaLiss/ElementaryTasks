package general;

public abstract class Dialog {
    public abstract String getData();
    public abstract String getLine();
    public abstract void print(String msg);

    public double getDouble(){
        return getDouble(ConstGeneral.PLEASE_INPUT_FLOAT);
    }

    public double getDouble(String msg){//, Class type//Integer.Class){
        String data;
        boolean valid=false;
        do {
            print(msg);
            data = getLine();
        }
        while(!NumberValidator.isDouble(data));
        return Double.parseDouble(data);
    }

    public int getInt(){
        return getInt(ConstGeneral.PLEASE_INPUT_INT);
    }

    public int getInt(String msg){
        String data;
        boolean valid=false;
        do {
            print(msg);
            data = getLine();
        }
        while(!NumberValidator.isInt(data));
        return Integer.parseInt(data);
    }

    public boolean yesNo(){
        return yesNo(ConstGeneral.YES_NO);
    }

    public boolean yesNo(String msg) {
        String answer;
        print(msg);
        answer = getData();
        //regular? \\s*y\\s* ignore case and yes
        return ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("yes")));
    }
}
