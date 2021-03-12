package task2_envelopes;

import general.Dialog;
import general.DoubleValidator;

public class Application {
    private Dialog dialog;
    private DoubleValidator validator;

    Application(Dialog dialog) {
        this.dialog = dialog;
        this.validator = new DoubleValidator(dialog);
    }

    public void run() {
        Envelope env1, env2;
        try {
            do {
                env1 = inputEnvelope(Const.FIRST_ENVELOPE);
                env2 = inputEnvelope(Const.SECOND_ENVELOPE);
                dialog.print(compareEnvelopes(env1, env2));
            }
            while (validator.yesNo());
        } catch (Exception e) {
            dialog.print(e.getMessage());
        }
    }

    private Envelope inputEnvelope(String whichEnvelope) {
        double width, height;
        dialog.print(whichEnvelope);
        width = validator.getNotZeroPositiveNumber(Const.WELCOME_MSG);
        height = validator.getNotZeroPositiveNumber(Const.WELCOME_MSG);
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