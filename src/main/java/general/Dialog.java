package general;

public abstract class Dialog {
    public abstract String getData();
    public abstract String getLine();
    public abstract void print(String msg);

    public double getDouble(){
        String data;
        do { data = getData(); } // you can print(ConstGeneral.INPUT_FLOAT)
        while(!Validator.isDouble(data));
        return Double.parseDouble(data);
    }

    public double getDouble(String msg){
        print(msg);
        return getDouble();
    }

    public int getInt(){
        String data;
        do { data = getData(); }
        while(!Validator.isInt(data));
        return Integer.parseInt(data);
    }

    public int getInt(String msg){
        print(msg);
        return getInt();
    }

    public boolean yesNo(String msg) {
        String answer;
        print(msg);
        answer = getData();
        return ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("yes")));
    }
}
