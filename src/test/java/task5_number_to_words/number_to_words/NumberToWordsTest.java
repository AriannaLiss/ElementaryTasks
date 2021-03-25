package task5_number_to_words.number_to_words;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordsTest {
    private static final int MAX_POW = 66;

    @ParameterizedTest
    @CsvFileSource(resources = "/numbers.csv")
    void testNumbers(long number, String expected) {
        //given
        NumberToWords ntw = new NumberToWords(number);
        //when
        String actual = ntw.toString() + ".";
        //then
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/thousands.csv")
    void testThousands(long number, String expected) {
        //given
        NumberToWords ntw = new NumberToWords(number);
        //when
        String actual = ntw.toString() + ".";
        //then
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/bigNumbers.csv")
    void testBigNumbers(BigInteger number, String expected) {
        //given
        NumberToWords ntw = new NumberToWords(number);
        //when
        String actual = ntw.toString() + ".";
        //then
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/boundsNumbers.csv")
    void testBounds(BigInteger number, String expected) {
        //given
        NumberToWords ntw = new NumberToWords(number);
        //when
        String actual = ntw.toString() + ".";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void testExceptionOutOfBounds() {
        //given
        BigInteger number = BigInteger.TEN.pow(MAX_POW);
        NumberToWords ntw = new NumberToWords(number);
        //then
        assertThrows(OutOfBoundsNumberException.class, () -> ntw.toString());
    }
}