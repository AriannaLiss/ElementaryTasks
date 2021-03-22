package task7_number_sequence;

public class NumberSequence {

    /**
     * @param length length of numberSequence, should be >0
     * @param minSquare a minimal square of numbers in a numberSequence
     * @return the numberSequence with natural numbers that aren't less minSquare
     */
    public static long[] getNumberSequence(int length, double minSquare){
        long[] numberSequence = new long[length];
        if (minSquare<=0) { minSquare=1; }
        long minNumber = (long)Math.ceil(Math.sqrt(minSquare));
        for (int i=0; i<length; i++,minNumber++){
            numberSequence[i]=minNumber;
        }
        return numberSequence;
    }
}
