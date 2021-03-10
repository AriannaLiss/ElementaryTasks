package task2_envelopes;

import org.jetbrains.annotations.NotNull;

/** Task 2 Analysis of envelopes

 There are two envelopes with sides (a,b) and (c,d).
 To estimate does one envelope fit into another.
 Program processes float data.
 Program asks user envelopes sides one by one.
 After every estimation program asks user whether he wants to continue.
 If user answers "y" or "yes" (register doesn't matter) program goes on anew.
 Otherwise program completes.
 */

public class Envelope implements Comparable<Envelope>{
    private final double width;
    private final double height;

    Envelope(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //Return true if Envelope [e] goes straight into this envelope
    private boolean fitStraight(Envelope e) {
        return ((e.width < width) && (e.height < height)) || ((e.height < width) && (e.width < height)) || fitDiagonal(e);
    }

    //Return true if Envelope [e] goes into this envelope on the diagonal
    private boolean fitDiagonal(Envelope e) {
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

    @Override
    public int compareTo(@NotNull Envelope e) {
        if (((e.width == width) && (e.height == height)) || ((e.height == width) && (e.width == height))) {
            return 0; //Envelopes are equal
        }
        if (fitStraight(e) || fitDiagonal(e)) {
            return 1; //Envelope [e] goes into this envelope
        }
        return -1; //Envelope [e] doesn't go into this envelope
    }
}