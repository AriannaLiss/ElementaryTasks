package task5_number_to_words;

import general.Dialog;
import task5_number_to_words.number_to_words.Millionaires;
import task5_number_to_words.number_to_words.NumberToWords;

import java.math.BigInteger;
import java.util.Random;

public class Test {
    private Dialog dialog;

    Test(Dialog dialog){
        this.dialog = dialog;
    }

    public void run(){//String[] args) {
            long[] test = {-395, 0, 9879, -0, 100000, -440260, 350650, 321105, -711123, 10324, 0232, 601052, 132004, 400012, 100000000};
            for (long n:test){
                testString(BigInteger.valueOf(n));
            }

            Random random= new Random();
            for (int i=0;i<10;i++){
                BigInteger n = BigInteger.ZERO;
                for (int j=1;j<random.nextInt(70);j++){
                    n = n.multiply(BigInteger.TEN).add(BigInteger.valueOf(random.nextInt(10)));
                }
                testString(n);
            }

            testString(new BigInteger("-4056064506500005062000545005064"));
            final BigInteger MAX_VALUE = Millionaires.thousandPow(22).subtract(BigInteger.ONE);
            testString(MAX_VALUE);
            try {
                testString(MAX_VALUE.add(BigInteger.ONE));
            } catch (Exception e) {
                dialog.print(e.getMessage());
            }
            testString(MAX_VALUE.multiply(BigInteger.valueOf(-1l)));
    }

    public void testString(BigInteger n){
        dialog.print(n+" - "+ NumberToWords.toString(n)+"\n");
    }
}
