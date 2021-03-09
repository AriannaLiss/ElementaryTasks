package task2_envelopes;

import general.ConsoleDialog;

public class Main {

    public static void main(String[] args) {
        Application application = new Application(new ConsoleDialog());
        application.run();
    }
}