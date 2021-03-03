package task2_envelopes;

public class Main {

    public static void main(String[] args) {
        Envelope env1, env2;
        String msg = "Please, input size of envelope's side: ";
        do {
            try {

                System.out.println("First envelop");
                env1 = new Envelope(Dialog.inFloat(msg), Dialog.inFloat(msg));
                System.out.println("Second envelop");
                env2 = new Envelope(Dialog.inFloat(msg), Dialog.inFloat(msg));

                int comparing = env1.compareTo(env2);
                if (comparing == 0) {
                    System.out.println("Envelopes are equal.");
                } else if (comparing > 0) {
                    System.out.println("Envelope 2 goes into envelope 1.");
                } else if (env2.compareTo(env1) > 0) {
                    System.out.println("Envelope 1 goes into envelope 2.");
                } else {
                    System.out.println("Envelopes don't fit each other.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (Dialog.yesNo());
        Dialog.close();
    }
}
