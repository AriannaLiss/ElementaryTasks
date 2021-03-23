package task5_number_to_words;

import general.*;
import task5_number_to_words.number_to_words.NumberToWords;
import task5_number_to_words.number_to_words.OutOfBoundsNumberException;

import java.math.BigInteger;

public class Application {
    private final String RULLS = "This application translates an integer number into words.\n" +
            "Example: 12 - двенадцать.\n" +
            "Application works with integer numbers less 10^66 \n";
    private final String INPUT_NUMBER = "Please, input number for translation: ";
    private final String NOT_INTEGER = " is not an integer number.\n";
    private final String DO_RUN_TEST = "Would you like to run a test? (y/n) ";

    private Dialog dialog;
    private NumberValidator validator;
    private InputOutput io;

    Application(InputOutput io) {
        this.io = io;
        validator = new IntegerValidator();
        dialog = new Dialog(io,validator);
    }

    public void run(){
        do {
            BigInteger num = new BigInteger(dialog.getStringNumber(INPUT_NUMBER));
            try{
                NumberToWords ntw = new NumberToWords(num);
                dialog.print(num.toString() + " - " + ntw+".\n");
            } catch (OutOfBoundsNumberException e) {
                dialog.print((e.getMessage()));
            }
        }
        while(dialog.yesNo());
        if (dialog.yesNo(DO_RUN_TEST)) {
            new Test(dialog).run();
        }
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
        if (dialog.yesNo(DO_RUN_TEST)) {
            new Test(dialog).run();
        }
    }
}
