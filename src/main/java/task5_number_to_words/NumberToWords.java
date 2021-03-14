package task5_number_to_words;


public class NumberToWords {

    public static String toString(long number){
        String numberToWord = "";
        if (number<0) {
            numberToWord+="минус ";
            number = -number;
        }
        else if (number == 0) {
            return "ноль";
        }
        numberToWord += Million.toString(number);
        return numberToWord;

    }
}
