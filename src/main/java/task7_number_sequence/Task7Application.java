package task7_number_sequence;

import general.*;
import task8_fibonacci.Fibonacci;

import java.util.Arrays;

/**
 * Number sequence.
 *
 * This application returns you a natural number sequence separated by comma.
 * Parameters: two natural numbers: n m
 * Where:      n is a length of the sequence
 *             m is a minimal square for numbers in the sequence.
 * Output:     the sequence with n natural numbers (theirs square are not less m).
 */
public class Task7Application implements Application {
    private InputOutput io;
    private IntegerValidator validator;
    private Dialog dialog;

    public Task7Application(InputOutput io){
        this.io = io;
        validator = new IntegerValidator();
        dialog = new Dialog(io, validator);
    }

    public void run(){
        dialog.print(Const.RULES);
        do {
            int length = dialog.getNotZeroPositiveNumber(Const.LENGTH).intValue();
            double sqrt = dialog.getNotZeroPositiveNumber(Const.SQR).doubleValue();
            io.print(Arrays.toString(NumberSequence.getNumberSequence(length,sqrt)) + "\n");
        }
        while (dialog.yesNo());
    }

    public void run(String... args) {
        try {
            if ((args.length >= 2)&&(validator.isPositiveNumber(args[0]))&&(validator.isPositiveNumber(args[1]))){
                io.print(Arrays.toString(NumberSequence.getNumberSequence(Integer.parseInt(args[0]),Double.parseDouble(args[1]))));
                return;
            }
            if (args.length != 0) {
                io.print(ConstGeneral.NOT_VALID_DATA);
            }
        }
        catch (Exception e){
            io.print(e.toString()+"\n");
        }
        io.print(Const.RULES);
    }
}
