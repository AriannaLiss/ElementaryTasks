package task7_number_sequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    @Test
    void getNumberSequenceTest() {
        //given
        int length = 20;
        double sqr = 53;
        long[] expected = new long [length];
        for (int i = 0; i < length; i++ ) {
            expected[i] = i + 8;
        }
        //when
        long[] actual = NumberSequence.getNumberSequence(length, sqr);
        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    void getNumberSequenceNegativeLengthTest() {
        //given
        int length = -2;
        double sqr = 53;
        //when
        assertThrows(NegativeArraySizeException.class, ()->NumberSequence.getNumberSequence(length,sqr));
    }

    @Test
    void getNumberSequenceNegativeSqrTest() {
        //given
        int length = 5;
        double sqr = -53;
        long[] expected = {1, 2, 3, 4, 5};
        //when
        long[] actual = NumberSequence.getNumberSequence(length,sqr);
        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    void zeroLengthTest(){
        //given
        int length = 0;
        double sqr = 121;
        //when
        long[] actual = NumberSequence.getNumberSequence(length,sqr);
        //then
        assertArrayEquals(new long[0], actual);
    }

    @Test
    void zeroSqrTest(){
        //given
        int length = 7;
        double sqr = 0;
        long[] expected = {1, 2, 3, 4, 5, 6, 7};
        //when
        long[] actual = NumberSequence.getNumberSequence(length,sqr);
        //then
        assertArrayEquals(expected, actual);
    }
}