package task2_envelopes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleDialog extends Dialog {
//final
    public static Scanner in = new Scanner(System.in);

    //should I devert print and scan?
    public double getDouble(String msg){
        System.out.print(msg);
        if (!in.hasNextDouble()) {
            in = new Scanner(System.in);
            throw new InputMismatchException(Const.INPUT_FLOAT);
        }
        return (in.nextFloat());
    }


    @Override
    public void print(String msg){
        System.out.print(msg);
    }

    public static float inFloat(String msg) {
        System.out.print(msg);
        if (!in.hasNextFloat()) {
            in = new Scanner(System.in);
            throw new InputMismatchException("You should input float.");
        }
        return (in.nextFloat());
    }

    public static boolean yesNo() {
        String answer;
        System.out.print(Const.YES_NO);
        answer = in.next();
        return ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("yes")));
    }

   /* public static void close() {
        in.close();
    }*/

}
