package task8_fibonacci;

import general.Dialog;
import general.InputOutput;
import general.IntegerValidator;

public class Application {
    private InputOutput io;
    private IntegerValidator validator;
    private Dialog dialog;

    Application(InputOutput io){
        this.io = io;
        this.validator = new IntegerValidator();
    }

    public void run(String... args) {
        try {
            Fibonacci fibonacci = new Fibonacci();
            if ((args.length == 1) && validator.isNumberInRange(args[0], 1, 9)) {
                fibonacci.getFibonacciRow(Integer.parseInt(args[0]));
                dialog.print(fibonacci.toString());
            } else if ((args.length > 1) && validator.isNumberInRange(args[0],Const.LOW_BOUND,Const.HIGH_BOUND) &&
                    validator.isNumberInRange(args[1],Const.LOW_BOUND,Const.HIGH_BOUND)) {
                fibonacci.getFibonacciRow(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                io.print(fibonacci.toString());
            } else {
                io.print(Const.RULES);
            }
        }
        catch (Exception e){
            io.print(e.toString()+"\n"+Const.RULES);
        }
    }
}
