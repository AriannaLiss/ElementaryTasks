package task9_palindrome;

import general.ConstGeneral;
import general.Dialog;
import general.InputOutput;
import general.IntegerValidator;

import java.math.BigInteger;


/**
 * Palindrome
 * <p>
 * This application return all palindromes from number or 0 if number doesn't have any palindromes.
 * Example:
 * number: 1234437
 * result: [44, 3443]
 * <p>
 * input: a number
 * output: list of palindromes or 0 if there are not palindromes
 */
public class Application {
    private static final String inputNumber = "Input a number: ";
    private Dialog dialog;

    Application(InputOutput io) {
        dialog = new Dialog(io, new IntegerValidator());
    }

    void run() {
        do {
            Palindrome palindrome = new Palindrome(new BigInteger(dialog.getStringNumber(inputNumber)));
            dialog.print(palindrome.getPalindromes() + "\n");
        }
        while (dialog.yesNo());
    }
}
