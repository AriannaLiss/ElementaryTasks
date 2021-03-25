package task9_palindrome;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * Palindrome
 * <p>
 * This application returns all palindromes in the number.
 * Example:
 * number: 1234437
 * result: [44, 3443]
 * <p>
 * input: a number
 * output: list of palindromes.
 */
public class Palindrome {
    private final String stringNumber;
    private final HashSet<String> palindromes;

    public Palindrome(BigInteger number) {
        this(number.toString());
    }

    public Palindrome(long number) {
        this(String.valueOf(number));
    }

    public Palindrome(String stringNumber){
        this.stringNumber = stringNumber;
        palindromes = new HashSet<>();
        lookForPalindromes();
    }

    public HashSet<String> getPalindromes() {
        return palindromes;
    }

    @Override
    public String toString() {
        return palindromes.toString();
    }

    private void lookForPalindromes() {
        for (int i = 1; i < stringNumber.length(); i++) {
            lookForPalindromes(stringNumber.substring(0, i), stringNumber.substring(i), "");
            if (i < stringNumber.length() - 1) {
                lookForPalindromes(stringNumber.substring(0, i), stringNumber.substring(i + 1), stringNumber.substring(i, i + 1));
            }
        }
    }

    private void lookForPalindromes(String leftSide, String rightSide, String subPalindrome) {
        char lastLeftChar = leftSide.charAt(leftSide.length() - 1);
        char firstRightChar = rightSide.charAt(0);
        if (lastLeftChar == firstRightChar) {
            subPalindrome = lastLeftChar + subPalindrome + firstRightChar;
            palindromes.add(subPalindrome);
            if ((leftSide.length() > 1) && (rightSide.length() > 1)) {
                lookForPalindromes(leftSide.substring(0, leftSide.length() - 1), rightSide.substring(1), subPalindrome);
            }
        }
    }
}
