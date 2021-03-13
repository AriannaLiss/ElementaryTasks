package task7_number_sequence;

import general.ConstGeneral;
import general.Dialog;
import general.IntegerValidator;
import java.util.Arrays;

public class Application {
    private Dialog dialog;
    private IntegerValidator validator;

    Application(Dialog dialog){
        this.dialog = dialog;
        validator = new IntegerValidator(dialog);
    }

    public void run(String... args) {
        try {
            if ((args.length >= 2)&&(validator.isPositiveNumber(args[0]))&&(validator.isPositiveNumber(args[1]))){
                dialog.print(Arrays.toString(NumberSequence.getNumberSequence(Integer.parseInt(args[0]),Double.parseDouble(args[1]))));
                return;
            }
            if (args.length != 0) {
                dialog.print(ConstGeneral.NOT_VALID_DATA);
            }
        }
        catch (Exception e){
            dialog.print(e.toString()+"\n");
        }
        dialog.print(Const.RULES);
    }
}
