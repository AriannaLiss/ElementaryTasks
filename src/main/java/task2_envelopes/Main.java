package task2_envelopes;

public class Main {

    public static void main(String[] args) {
        Dialog dialog = new ConsoleDialog();
        Counting counting = new Counting(dialog);
        counting.run();
    }
}
