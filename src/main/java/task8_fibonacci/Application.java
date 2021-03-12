package task8_fibonacci;

import general.Dialog;
import general.IntegerValidator;

public class Application {
    private Dialog dialog;
    private IntegerValidator validator;

    Application(Dialog dialog){
        this.dialog = dialog;
        validator = new IntegerValidator(dialog);
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
                dialog.print(fibonacci.toString());
            } else {
                dialog.print(Const.RULES);
            }
        }
        catch (Exception e){
            dialog.print(e.toString()+"\n"+Const.RULES);
        }
    }
}
