package task2_envelopes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {

    private static Scanner in = new Scanner(System.in);

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
        System.out.print("Do you want to continue? (y/yes for continue) ");
        answer = in.next();
        return ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("yes")));
    }

    public static void close() {
        in.close();
    }

}
