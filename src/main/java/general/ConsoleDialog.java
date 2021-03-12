package general;

import java.util.Scanner;

public class ConsoleDialog extends Dialog {
    public static final Scanner in = new Scanner(System.in);

    @Override
    public String getData() {
        return in.next();
    }

    @Override
    public String getLine() {
        return in.nextLine().trim();
    }

    @Override
    public void print(String msg){
        System.out.print(msg);
    }
}
