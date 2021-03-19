package task7_number_sequence;

import general.ConstGeneral;
import general.InputOutput;
import general.IntegerValidator;
import java.util.Arrays;

public class Application {
    private InputOutput io;
    private IntegerValidator validator;

    Application(InputOutput io){
        this.io = io;
        validator = new IntegerValidator();
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
