package general;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DoubleValidatorTest {
    private final NumberValidator validator = new DoubleValidator();

    @ParameterizedTest
    @ValueSource(strings = {"321.3 ", " 0.1", " 0", "-0", "-232.2 "})
    void isNumber_True(String s) {
        assertTrue(validator.isNumber(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1.1.", " ", "0,3", "aoj", "2 3"})
    void isNumber_False(String s) {
        assertFalse(validator.isNumber(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3213.21", "0", " 200000"})
    void isPositiveNumber_True(String s){
        assertTrue(validator.isPositiveNumber(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-233.2", "-0"})
    void isPositiveNumber_Negative_False(String s) {
        assertFalse(validator.isPositiveNumber(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jp;ijkl", ".1"})
    void isPositiveNumber_NotNumber_False(String s) {
        assertFalse(validator.isPositiveNumber(s));
    }

    @Test
    void isNumberInRange_True() {
        //given
        double from = 10;
        double to = 1000;
        String s = "100.35";
        //then
        assertTrue(validator.isNumberInRange(s,from,to));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100045.63","0","-100"})
    void isNumberInRange_False(String s) {
        //given
        double from = 10;
        double to = 1000;
        //then
        assertFalse(validator.isNumberInRange(s,from,to));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10", "10.001", "999.999", "1000",})
    void isNumberInRange_BoundsValues_True(String s) {
        //given
        double from = 10;
        double to = 1000;
        //then
        assertTrue(validator.isNumberInRange(s,from,to));
    }

    @ParameterizedTest
    @ValueSource(strings = {"9.99", "1000.1"})
    void isNumberInRange_BoundsValues_False(String s) {
        //given
        double from = 10;
        double to = 1000;
        //then
        assertFalse(validator.isNumberInRange(s,from,to));
    }

    @ParameterizedTest
    @CsvSource({"365, 365", "-0001,-1", "-0,-0", "0,0", "-100000,-100000",
                "36.5, 36.5", "-00.01,-0.01", "-0.0,-0", "0.010000,0.01", "-1000.00,-1000"})
    void parseNumber(String s, double expected) {
        //when
        Number actual = validator.parseNumber(s);
        //then
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1.1.", " ", "0,3", "aoj", "2 3"})
    void parseNumber_ThrowsNumberFormatException(String s) {
        assertThrows(NumberFormatException.class, () -> validator.parseNumber(s));
    }
}