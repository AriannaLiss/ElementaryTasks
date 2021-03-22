package task5_number_to_words.number_to_words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void testToStringFemale() {
        //given
        Unit unit = new Unit(1);
        String expected = "одна";
        //when
        String actual = unit.toString(Word.Sex.FEMALE);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {
        //given
        Unit unit = new Unit(1);
        String expected = "один";
        //when
        String actual = unit.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void largeNumberTestToString() {
        //given
        Unit unit = new Unit(10345);
        String expected = "пять";
        //when
        String actual = unit.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testToStringZero() {
        //given
        Unit unit = new Unit(0);
        String expected = "";
        //when
        String actual = unit.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void negativeTestToString() {
        //given
        Unit unit = new Unit(-2);
        String expected = "";
        //when
        String actual = unit.toString();
        //then
        assertEquals(expected,actual);
    }
}