package task5_number_to_words;

import general.Dialog;
import task5_number_to_words.number_to_words.NumberToWords;
import java.math.BigInteger;

public class Application {
    private Dialog dialog;

    Application(Dialog dialog){
        this.dialog = dialog;
    }

    public void run(String[] args) {
        try {
            for (String num : args) {
                dialog.print(num + ": " + NumberToWords.toString(new BigInteger(num)) + "\n");
            }
        } catch (Exception e) {
            dialog.print(e.getMessage());
        }
    }
}
