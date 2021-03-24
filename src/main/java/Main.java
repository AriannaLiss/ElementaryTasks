import general.*;
import task1_chessboard.Task1Application;

public class Main {

    public static void main(String[] args) {
        InputOutput io = new ConsoleInputOutput();
        try{
            new ChooseTask(io).run();
        } catch (Exception e) {
        io.print(e.getMessage());
        }
    }
}
