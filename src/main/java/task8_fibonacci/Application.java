package task8_fibonacci;

import general.Dialog;
import general.InputOutput;
import general.IntegerValidator;

public class Application {
    private InputOutput io;
    private IntegerValidator validator;
    private Dialog dialog;

    Application(InputOutput io) {
        this.io = io;
        validator = new IntegerValidator();
        dialog = new Dialog(io,validator);
    }

    public void run(){
        Fibonacci fibonacci = new Fibonacci();
        dialog.print(Const.RULES);
        do {
            int mode = dialog.getNumberInRange(Const.MODE, 0, 2).intValue();
            if (mode == 1) {
                fibonacci.getFibonacciRow(dialog.getNumberInRange(Const.COUNT_OF_DIGITS, 1, 9).intValue());
                dialog.print(fibonacci.toString() + "\n");
            } else if (mode == 2) {
                int from = dialog.getNumberInRange(Const.FROM, Const.LOW_BOUND, Const.HIGH_BOUND).intValue();
                int to = dialog.getNumberInRange(Const.TO, Const.LOW_BOUND, Const.HIGH_BOUND).intValue();
                fibonacci.getFibonacciRow(from, to);
                dialog.print(fibonacci.toString() + "\n");
            } else {
                dialog.print(Const.RULES);
            }
        }
        while (dialog.yesNo());
    }

    public void run(String... args) {
        Fibonacci fibonacci = new Fibonacci();
        if ((args.length == 1) && validator.isNumberInRange(args[0], 1, 9)) {
            fibonacci.getFibonacciRow(Integer.parseInt(args[0]));
            io.print(fibonacci.toString());
        } else if ((args.length > 1) && validator.isNumberInRange(args[0], Const.LOW_BOUND, Const.HIGH_BOUND) &&
                validator.isNumberInRange(args[1], Const.LOW_BOUND, Const.HIGH_BOUND)) {
            fibonacci.getFibonacciRow(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            io.print(fibonacci.toString());
        } else {
            io.print(Const.RULES);
        }
    }
}
