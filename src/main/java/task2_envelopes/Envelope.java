package task2_envelopes;

/** Task 2 Analysis of envelopes

 There are two envelopes with sides (a,b) and (c,d).
 To estimate does one envelope fit into another.
 Program processes float data.
 Program asks user envelopes sides one by one.
 After every estimation program asks user whether he wants to continue.
 If user answers "y" or "yes" (register doesn't matter) program goes on anew.
 Otherwise program completes.
 */

public class Envelope {
    private final double width;
    private final double height;

    Envelope(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /** Check is it possible to put envelope e in this envelop
     *
     * @param e is Envelope which we try to put into this envelope
     * @return true if envelope e fits into this envelop, false otherwise
     */
    public boolean isPossiblePut(Envelope e) {
        return (e != null) && (isFitStraight(e) || isFitDiagonal(e));
    }

    /**
     * It returns true if Envelope [e] goes straight into this envelope
     */
    private boolean isFitStraight(Envelope e) {
        return ((e.width < width) && (e.height < height)) || ((e.height < width) && (e.width < height));
    }

    /**
     * It returns true if Envelope [e] goes into this envelope on the diagonal
     */
    private boolean isFitDiagonal(Envelope e) {
        double diagonal = Math.sqrt(Math.pow(e.width, 2) + Math.pow(e.height, 2));
        double h12 = Math.pow(diagonal, 2) - Math.pow(width, 2);
        double w12 = Math.pow(diagonal, 2) - Math.pow(height, 2);
        if ((h12 <= 0) && (w12 <= 0)) return false;
        double h2 = (height - Math.sqrt(h12)) / 2.;
        double w2 = (width - Math.sqrt(w12)) / 2.;
        if ((h2 <= 0) && (w2 <= 0)) return false;
        double z = Math.sqrt(Math.pow(h2, 2) + Math.pow(w2, 2));
        return ((z > e.width) || (z > e.height));
    }
}