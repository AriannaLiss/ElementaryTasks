package task8_fibonacci;

import general.Dialog;
import general.NumberValidator;

public class Application implements Runnable {
    Dialog dialog;

    Application(Dialog dialog){
        this.dialog = dialog;
    }

    @Override
    public void run() {
        dialog.print(Const.RULES);
    }

    public void run(String... args) {
        try {
            Fibonacci fibonacci = new Fibonacci();
            if ((args.length == 1) && NumberValidator.isIntInRange(args[0], 1, 9)) {
                fibonacci.getFibonacciRow(Integer.parseInt(args[0]));
                dialog.print(fibonacci.toString());
            } else if ((args.length > 1) && NumberValidator.isIntInRange(args[0],Const.LOW_BOUND,Const.HIGH_BOUND) &&
                    NumberValidator.isIntInRange(args[1],Const.LOW_BOUND,Const.HIGH_BOUND)) {
                fibonacci.getFibonacciRow(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                dialog.print(fibonacci.toString());
            } else {
                run();
            }
        }
        catch (Exception e){
            dialog.print(e.toString()+"\n"+Const.RULES);
        }
    }
}
