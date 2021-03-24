import general.Application;
import general.InputOutput;

public class Rules implements Application {
    private static final String RULES = "For run application you should input number of task (1-9).\n"+
            "Task 4 and 6 now in the development. Would be soon.\n";
    private InputOutput io;

    Rules(InputOutput io){
        this.io = io;
    }
    @Override
    public void run() {
        io.print(RULES);
    }
}
