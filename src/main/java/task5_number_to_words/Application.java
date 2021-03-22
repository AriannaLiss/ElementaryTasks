package task5_number_to_words;

import general.ConstGeneral;
import general.Dialog;
import general.IntegerValidator;
import general.Validator;
import task5_number_to_words.number_to_words.NumberToWords;
import task5_number_to_words.number_to_words.OutOfBoundsNumberException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    private final String RULLS = "This application translates an integer number into words.\n" +
            "Example: 12 - двенадцать.\n" +
            "Application works with integer numbers less 10^66 \n";
    private final String NOT_INTEGER = " is not an integer number.\n";
    private final String DO_RUN_TEST = "Would you like to run a test? (y/n) ";

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
                    dialog.print(num + ConstGeneral.DASH + ntw + ConstGeneral.NEW_LINE);
                } catch (OutOfBoundsNumberException e) {
                    dialog.print((e.getMessage()));
                }
            } else {
                dialog.print(ConstGeneral.QUOTE + num + ConstGeneral.QUOTE + NOT_INTEGER);
            }
        }
        if (validator.yesNo(DO_RUN_TEST)) {
            new Test(dialog).run();
        }
    }
}
