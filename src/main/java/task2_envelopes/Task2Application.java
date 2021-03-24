package task2_envelopes;

import general.Application;
import general.DoubleValidator;
import general.InputOutput;
import general.Dialog;

public class Task2Application implements Application {
    private Dialog dialog;

    public Task2Application(InputOutput io) {
        dialog = new Dialog(io, new DoubleValidator());
    }

    public void run() {
        Envelope env1, env2;
        do {
            env1 = inputEnvelope(Const.FIRST_ENVELOPE);
            env2 = inputEnvelope(Const.SECOND_ENVELOPE);
            dialog.print(compareEnvelopes(env1, env2));
        }
        while (dialog.yesNo());
    }

    private Envelope inputEnvelope(String whichEnvelope) {
        double width, height;
        dialog.print(whichEnvelope);
        width = dialog.getNotZeroPositiveNumber(Const.WELCOME_MSG).doubleValue();
        height = dialog.getNotZeroPositiveNumber(Const.WELCOME_MSG).doubleValue();
        return new Envelope(width, height);
    }

    private String compareEnvelopes(Envelope env1, Envelope env2) {
        if (env1.isPossiblePut(env2)) {
            return Const.FIRST_GREATER;
        } else if (env2.isPossiblePut(env1)) {
            return Const.SECOND_GREATER;
        }
        return Const.DONT_FIT;
    }
}