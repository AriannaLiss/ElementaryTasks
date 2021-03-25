package task9_palindrome;

import general.Application;
import general.Dialog;
import general.InputOutput;
import general.IntegerValidator;

import java.math.BigInteger;

public class Task9Application implements Application {
    private static final String RULES = "\nThis application returns all palindromes in the number.\n" +
            "Example:\nnumber: 1234437\nresult: [44, 3443]\n";
    private static final String INPUT_A_NUMBER = "Input a number: ";
    private static final String NO_PALINDROMES = "This number doesn't have any palindromes.\n";
    private final Dialog dialog;

    public Task9Application(InputOutput io) {
        dialog = new Dialog(io, new IntegerValidator());
    }

    public void run() {
        dialog.print(RULES);
        do {
            dialog.print("\n");
            Palindrome palindrome = new Palindrome(new BigInteger(dialog.getStringNumber(INPUT_A_NUMBER)));
            if (palindrome.getPalindromes().isEmpty()){
                dialog.print(NO_PALINDROMES);
            }
            else {
                dialog.print(palindrome + "\n");
            }
        }
        while (dialog.yesNo());
    }
}
