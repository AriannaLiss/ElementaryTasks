package task5_number_to_words.number_to_words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void testToStringFemale() {
        //given
        Unit unit = new Unit((short)1);
        String expected = "одна";
        //when
        String actual = unit.toString(Number.Gender.FEMALE);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {
        //given
        Unit unit = new Unit((short)1);
        String expected = "один";
        //when
        String actual = unit.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void largeNumberTestToString() {
        //given
        Unit unit = new Unit((short)10345);
        String expected = "пять";
        //when
        String actual = unit.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testToStringZero() {
        //given
        Unit unit = new Unit((short)0);
        String expected = "";
        //when
        String actual = unit.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void negativeTestToString() {
        //given
        Unit unit = new Unit((short)-2);
        String expected = "";
        //when
        String actual = unit.toString();
        //then
        assertEquals(expected,actual);
    }
}