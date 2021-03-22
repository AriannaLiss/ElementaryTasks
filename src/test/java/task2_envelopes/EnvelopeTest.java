package task2_envelopes;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeTest {

    @Test
    void testIsPossiblePutStraight() {
        //given
        Envelope envelope1 = new Envelope(2,5);
        Envelope envelope2 = new Envelope(4,1);
        //when
        boolean actual = envelope1.isPossiblePut(envelope2);
        //then
        assertTrue(actual);
    }

    @Test
    void testIsPossiblePutDiagonal() {
        //given
        Envelope envelope1 = new Envelope(2,5);
        Envelope envelope2 = new Envelope(0.1,5.1);
        //when
        boolean actual = envelope1.isPossiblePut(envelope2);
        //then
        assertTrue(actual);
    }

    @Test
    void NegativeTestIsPossiblePutDiagonal() {
        //given
        Envelope envelope1 = new Envelope(2,5);
        Envelope envelope2 = new Envelope(0.1,5.1);
        //when
        boolean actual = envelope2.isPossiblePut(envelope1);
        //then
        assertFalse(actual);
    }

    @Test
    void EqualTestIsPossiblePut() {
        //given
        Envelope envelope1 = new Envelope(2,5);
        //when
        boolean actual = envelope1.isPossiblePut(envelope1);
        //then
        assertFalse(actual);
    }
}