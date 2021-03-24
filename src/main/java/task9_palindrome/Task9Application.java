package task9_palindrome;

import general.Application;
import general.Dialog;
import general.InputOutput;
import general.IntegerValidator;

import java.math.BigInteger;


/**
 * Palindrome
 * <p>
 * This application return all palindromes in the number.
 * Example:
 * number: 1234437
 * result: [44, 3443]
 * <p>
 * input: a number
 * output: list of palindromes or message if there are not any palindromes.
 */
public class Task9Application implements Application {
    private static final String INPUT_A_NUMBER = "Input a number: ";
    private static final String NO_PALINDROMES = "This number doesn't have any palindromes.\n";
    private final Dialog dialog;

    public Task9Application(InputOutput io) {
        dialog = new Dialog(io, new IntegerValidator());
    }

    public void run() {
        do {
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
