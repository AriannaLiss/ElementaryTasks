package task9_palindrome;

import java.math.BigInteger;
import java.util.ArrayList;

public class Palindrome {
    private final String stringNumber;
    private ArrayList<String> palindromes = new ArrayList<>();

    Palindrome(BigInteger number){
        stringNumber = number.toString();
    }

    Palindrome(long number){
        stringNumber = String.valueOf(number);
    }

    public String getPalindromes(){
        for (int i=1;i<stringNumber.length();i++){
            getPalindromes(stringNumber.substring(0,i),stringNumber.substring(i),"");
            if(i<stringNumber.length()-1) {
                getPalindromes(stringNumber.substring(0, i), stringNumber.substring(i + 1), stringNumber.substring(i, i + 1));
            }
        }
        if (palindromes.isEmpty()){
            return "0";
        }
        return palindromes.toString();
    }

    private void getPalindromes(String leftSide, String rightSide,String subPalindrome){
        char lastLeftChar = leftSide.charAt(leftSide.length()-1);
        char firstRightChar = rightSide.charAt(0);
        if (lastLeftChar==firstRightChar){
            subPalindrome = lastLeftChar + subPalindrome + firstRightChar;
            if (!palindromes.contains(subPalindrome)) {
                palindromes.add(subPalindrome);
            }
            if ((leftSide.length()>1)&&(rightSide.length()>1)) {
                getPalindromes(leftSide.substring(0, leftSide.length() - 1), rightSide.substring(1),subPalindrome);
            }
        }
    }

    @Override
    public String toString(){
        if (palindromes.isEmpty()){
            getPalindromes();
        }
        return palindromes.toString();
    }

}
