import general.Application;
import general.Dialog;
import general.InputOutput;
import general.IntegerValidator;
import task1_chessboard.Task1Application;
import task2_envelopes.Task2Application;
import task3_triangles.Task3Application;
import task5_number_to_words.Task5Application;
import task7_number_sequence.Task7Application;
import task8_fibonacci.Task8Application;
import task9_palindrome.Task9Application;

public class ChooseTask {
    private static final String CHOOSE_TASK = "Please, choose number of task: ";
    private static final String TASKS = "Tasks\n" +
            "1 - Chess Board\n" +
            "2 - Envelopes\n" +
            "3 - Triangles\n" +
            "4 - Files\n" +
            "5 - Number to String\n" +
            "6 - Happy Tickets\n" +
            "7 - Number Sequence\n" +
            "8 - Fibonacci\n" +
            "9 - Palindrome\n";
    private static final String NEW_TASK = "Would you like to choose a new task? (y/n) ";
    private final InputOutput io;
    private final Dialog dialog;

    public ChooseTask(InputOutput io){
        this.io = io;
        dialog = new Dialog(io, new IntegerValidator());
    }

    public void run(){
        do {
            dialog.print(TASKS);
            int task = dialog.getNumberInRange(CHOOSE_TASK, 1, 9).intValue();
            chooseTask(task).run();
        }
        while(dialog.yesNo(NEW_TASK));
    }

    private Application chooseTask(int task) {
        switch (task) {
            case 1:
                return new Task1Application(io);
            case 2:
                return new Task2Application(io);
            case 3:
                return new Task3Application(io);
            case 5:
                return new Task5Application(io);
            case 7:
                return new Task7Application(io);
            case 8:
                return new Task8Application(io);
            case 9:
                return new Task9Application(io);
        }
        return new Rules(io);
    }
}
