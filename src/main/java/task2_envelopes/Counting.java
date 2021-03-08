package task2_envelopes;

public class Counting implements Runnable{
    Dialog dialog;

    Counting(Dialog dialog){
        this.dialog = dialog;
    }

    @Override
    public void run() {
        Envelope env1, env2;
        do {
            try {
                env1 = inputEnvelope(Const.FIRST_ENVELOPE);
                env2 = inputEnvelope(Const.SECOND_ENVELOPE);
                dialog.print(compareEnvelopes(env1,env2));
            } catch (Exception e) {
                dialog.print(e.getMessage());
            }
        }
        while (ConsoleDialog.yesNo());
    }

    private String compareEnvelopes(Envelope env1, Envelope env2){
        int comparing = env1.compareTo(env2);
        if (comparing == 0) {
            return Const.ENVELOPES_EQUAL;
        } else if (comparing > 0) {
            return Const.FIRST_GREATER;
        } else if (env2.compareTo(env1) > 0) {
            return Const.SECOND_GREATER;
        }
        return Const.DONT_FIT;
    }

    private Envelope inputEnvelope(String whichEnvelope){
        double width, height;
        boolean isValid;
        do {
            dialog.print(whichEnvelope);
            width = dialog.getDouble(Const.WELCOME_MSG);
            height = dialog.getDouble(Const.WELCOME_MSG);
            isValid=isValid(width)&&isValid(height);
            if (!isValid){
                dialog.print(Const.NOT_VALID_DATA);
            }
        }
        while (!isValid);
        return new Envelope(width, height);
    }

    private boolean isValid(double gZeroValue){
        return (gZeroValue>0);
    }
}
