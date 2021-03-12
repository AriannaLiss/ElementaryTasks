package task2_envelopes;

import general.Dialog;
import general.ConstGeneral;

public class Application {
    private Dialog dialog;

    Application(Dialog dialog) {
        this.dialog = dialog;
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
        boolean isValid;
        do {
            dialog.print(whichEnvelope);
            width = dialog.getDouble(Const.WELCOME_MSG);
            height = dialog.getDouble(Const.WELCOME_MSG);
            isValid = (width>0) && (height>0);
            if (!isValid) {
                dialog.print(ConstGeneral.NOT_VALID_DATA);
            }
        }
        while (!isValid);
        return new Envelope(width, height);
    }

    private String compareEnvelopes(Envelope env1, Envelope env2) {
/*        int comparing = env1.fit(env2);
        if (comparing == 0) {
            return Const.ENVELOPES_EQUAL;
        } else if (comparing > 0) {
            return Const.FIRST_GREATER;
        } else if (env2.fit(env1) > 0) {
            return Const.SECOND_GREATER;
        }*/
        if (env1.isPossiblePut(env2)){
            return Const.FIRST_GREATER;
        } else if (env2.isPossiblePut(env1)){
            return Const.SECOND_GREATER;
        }
        return Const.DONT_FIT;
    }
}