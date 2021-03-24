package general;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerValidatorTest {
    private final NumberValidator validator = new IntegerValidator();

    @Test
    void isNumber_True() {
        //given
        String s = "321321";
        //then
        assertTrue(validator.isNumber(s));
    }

    @Test
    void isNumber_NegativeNumber_True() {
        //given
        String s = "-1321";
        //then
        assertTrue(validator.isNumber(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1.1", "0,3", "aoj", "2 3"})
    void isNumber_False(String s) {
        //then
        assertFalse(validator.isNumber(s));
    }

    @Test
    void isPositiveNumber_True() {
        //given
        String s = "321321";
        //then
        assertTrue(validator.isPositiveNumber(s));
    }

    @Test
    void isPositiveNumber_Zero_True() {
        //given
        String s = "0";
        //then
        assertTrue(validator.isPositiveNumber(s));
    }

    @Test
    void isPositiveNumber_Negative_False() {
        //given
        String s = "-1321";
        //then
        assertFalse(validator.isPositiveNumber(s));
    }

    @Test
    void isNumberInRange_True() {
        //given
        double from = 10;
        double to = 1000;
        String s = "100";
        //then
        assertTrue(validator.isNumberInRange(s,from,to));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10004563","0","-100"})
    void isNumberInRange_False(String s) {
        //given
        double from = 10;
        double to = 1000;
        //then
        assertFalse(validator.isNumberInRange(s,from,to));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10", "11", "999", "1000"})
    void isNumberInRange_BoundsValues_True(String s) {
        //given
        double from = 10;
        double to = 1000;
        //then
        assertTrue(validator.isNumberInRange(s,from,to));
    }

    @ParameterizedTest
    @ValueSource(strings = {"9", "1001"})
    void isNumberInRange_BoundsValues_False(String s) {
        //given
        double from = 10;
        double to = 1000;
        //then
        assertFalse(validator.isNumberInRange(s,from,to));
    }

    @ParameterizedTest
    @CsvSource({"365, 365", "-0001,-1", "-0,0", "0,0", "-100000,-100000"})
    void parseNumber(String s, Integer expected) {
        //when
        Number actual = validator.parseNumber(s);
        //then
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1.1", "0,3", "aoj"})
    void parseNumber_ThrowsNumberFormatException(String s) {
        assertThrows(NumberFormatException.class, () -> validator.parseNumber(s));
    }
}