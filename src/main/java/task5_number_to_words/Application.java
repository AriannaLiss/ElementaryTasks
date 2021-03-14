package task5_number_to_words;

import general.Dialog;

import java.math.BigInteger;

public class Application {
    private Dialog dialog;

    Application(Dialog dialog){
        this.dialog = dialog;
    }

    public void run(String[] args) {
        try {
        /*for(String num: args){
            dialog.print(num+": "+NumberInWords.toString(Integer.parseInt(num))+"\n");
        }*/
            //TODO BigInteger and good test for diapason -10^70 +10^70
            long[] test = {-395, 0, 9879, 100000, -440260, 350650, 321105, -711123, 10324, 0232, 601052, 132004, 400012};
            for (int pow = 0; pow < 15; pow += 7) {
                // BigInteger number= new BigInteger();
                long number;
                for (int i = pow; i >= 0; i -= 2) {
                    //number = number.add(new BigInteger(n*Math.pow(10,i)));
                    for (long n : test) {
                        number = n;
                        number += n * Math.pow(10, i);
                        // BigInteger number = new BigInteger();
                        testString(number);
                    }
                }
            }
        } catch (Exception e) {
            dialog.print(e.getMessage());
        }
    }

    public void testString(long n){
        dialog.print(n+": "+ NumberToWords.toString(n)+"\n");
    }
}
