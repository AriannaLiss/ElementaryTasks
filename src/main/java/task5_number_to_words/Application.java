package task5_number_to_words;

import general.Dialog;

public class Application {
    private Dialog dialog;

    Application(Dialog dialog){
        this.dialog = dialog;
    }

    public void run(String[] args){
        /*for(String num: args){
            dialog.print(num+": "+NumberInWords.toString(Integer.parseInt(num))+"\n");
        }*/
/*        int start = 100000;
        for (int i=start;i<10*start;i+=17013){
            testString(i);

        }
  */
        long[] test ={-395, 0, 9879, 100000, 440260, 350650, 321105,711123, 10324, 0232, 601052, 132004, 400012};
        for (long n: test){
            testString(n*100000+n);
        }
    }

    public void testString(long n){
        dialog.print(n+": "+ NumberToWords.toString(n)+"\n");
    }
}
