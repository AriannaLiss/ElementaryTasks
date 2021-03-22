import general.ConsoleInputOutput;
import general.Dialog;
import general.InputOutput;
import general.IntegerValidator;

public class Main {
    private static final String CHOOSE_TASK = "Please, choose number of task: ";
    private static final String TASKS =
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

    public static void main(String[] args) {
        Dialog dialog = new Dialog(new ConsoleInputOutput(), new IntegerValidator());
        try{
            do {
                dialog.print(TASKS);
                int task = dialog.getNumberInRange(CHOOSE_TASK, 1, 9).intValue();
                switch (task) {
                    case 2:
                        task2_envelopes.Main.main(args); break;
                    case 3:
                        task3_triangles.Main.main(args); break;
                    case 7:
                        task7_number_sequence.Main.main(args); break;
                    case 8:
                        task8_fibonacci.Main.main(args); break;
                    case 9:
                        task9_palindrome.Main.main(args); break;
                }
            }
            while(dialog.yesNo(NEW_TASK));
        } catch (Exception e) {
        dialog.print(e.getMessage());
    }
    }
}
