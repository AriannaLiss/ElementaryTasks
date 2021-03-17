package task5_number_to_words;

import general.Dialog;
import general.IntegerValidator;
import general.Validator;
import task5_number_to_words.number_to_words.NumberToWords;
import task5_number_to_words.number_to_words.Word;

import java.math.BigInteger;

public class Application {
    private final String RULLS = "This application translates an integer number into words.\n" +
            "Example: 12 - двенадцать.\n" +
            "Application with integer numbers less 10^66 \n";
    private Dialog dialog;
    private Validator validator;

    Application(Dialog dialog) {
        this.dialog = dialog;
        validator = new IntegerValidator(dialog);
    }

    public void run(String[] args) {
        if (args.length == 0) {
            dialog.print(RULLS);
        }
        for (String num : args) {
            if (validator.isNumber(num)) {
                try {
                    NumberToWords ntw = new NumberToWords(new BigInteger(num));
                    dialog.print(num + " - " + ntw + "\n");
                } catch (Exception e) { //TODO my exception
                    dialog.print((e.getMessage()));
                }
            } else {
                dialog.print("'" + num + "' is not an integer number.\n");
            }
        }
        if (validator.yesNo("Would you like to run a test? (y/n) ")) {
            new Test(dialog).run();
        }
    }
}
