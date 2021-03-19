package task2_envelopes;

import general.DoubleValidator;
import general.InputOutput;
import general.Dialog;

public class Application {
    private Dialog dialog;

    Application(InputOutput io) {
        dialog = new Dialog(io,new DoubleValidator());
    }

    public void run() {
        Envelope env1, env2;
        try {
            do {
                env1 = inputEnvelope(Const.FIRST_ENVELOPE);
                env2 = inputEnvelope(Const.SECOND_ENVELOPE);
                dialog.print(compareEnvelopes(env1, env2));
            }
            while (dialog.yesNo());
        } catch (Exception e) {
            dialog.print(e.getMessage());
        }
    }

    private Envelope inputEnvelope(String whichEnvelope) {
        double width, height;
        dialog.print(whichEnvelope);
        width = (double)dialog.getNotZeroPositiveNumber(Const.WELCOME_MSG);
        height = (double)dialog.getNotZeroPositiveNumber(Const.WELCOME_MSG);
        return new Envelope(width, height);
    }

    private String compareEnvelopes(Envelope env1, Envelope env2) {
        if (env1.isPossiblePut(env2)){
            return Const.FIRST_GREATER;
        } else if (env2.isPossiblePut(env1)){
            return Const.SECOND_GREATER;
        }
        return Const.DONT_FIT;
    }
}