package task9_palindrome;

import java.util.ArrayList;

public class Palindrome<stringUtils> {
    //private long number;
    private String stringNumber;
   // private ArrayList<Byte> arrayNumbers;
    //private char[] charNumber;
    ArrayList<String> palindromes;

    Palindrome(String stringNumber){
        this.stringNumber = stringNumber;
        palindromes = new ArrayList<>();
    }

    Palindrome(long number) {
        //this.number = number;
        // stirngNumber = (String)nubmer;
    }

    
    private void getPalindromes(char[] charsNumber){
        ArrayList<String> palindromes = new ArrayList<>();
        char[] substr = new char [charsNumber.length];
        for (int i=1;i<charsNumber.length;i++)
        {
            int lastChar = substr.length-1;
            if (charsNumber[i]==substr[lastChar]) {
                palindromes.add(new String(new char[]{substr[lastChar], charsNumber[i]}));
                for (int j = 1;j<substr.length;j++) {
                    if(charsNumber[i+j]==substr[lastChar-j]){
                        palindromes.add(new String(new char[]{substr[lastChar], charsNumber[i]}));
                    }
                }
            }
        }
    }

    public String getPalindromes(){ //only first time!!
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
            //StringBuilder subPalindromeBuilder = new StringBuilder().append(lastLeftChar).append(subPalindrome).append(firstRightChar);
           //subPalindrome = new String(new char[]{lastLeftChar,subPalindrome.toCharArray(),firstRightChar})
            subPalindrome = (new StringBuilder().append(lastLeftChar).append(subPalindrome).append(firstRightChar)).toString();
            palindromes.add(subPalindrome);
            if ((leftSide.length()>1)&&(rightSide.length()>1)) {
                getPalindromes(leftSide.substring(0, leftSide.length() - 1), rightSide.substring(1),subPalindrome);
            }
        }
    }

    private void getArray(long number){
        //ArrayList<Byte> arrayNumbers=new ArrayList<Byte>();
        //arrayNumbers.add((char)(number%10));
        //getArray(number/10);
    }
}
