package task5_number_to_words.number_to_words;

import java.math.BigInteger;

// !other classes in this package work only with not null positive numbers
public class NumberToWords {

    public static String toString(BigInteger number){
        String numberToWord = "";
        if (number.signum()<0) {
            numberToWord+="минус ";
            number = number.abs();
        }
        else if (number.signum()==0) {
            return "ноль";
        }
        numberToWord += Millioners.toString(number);
        return numberToWord;
    }

    public static String toString(long number){
        return toString(BigInteger.valueOf(number));
    }
/*
    public static String toString(long number){
        String numberToWord = "";
        if (number<0) {
            numberToWord+="минус ";
            number = -number;
        }
        else if (number == 0) {
            return "ноль";
        }
        numberToWord += Millioners.toString(number);
        return numberToWord;
    }*/
}
