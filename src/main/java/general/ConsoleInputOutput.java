package general;

import java.util.Scanner;

public class ConsoleInputOutput extends InputOutput {
    public static final Scanner in = new Scanner(System.in);

    @Override
    public String getLine() {
        return in.nextLine();
    }

    @Override
    public void print(String msg){
        System.out.print(msg);
    }
}
