package task5_number_to_words.number_to_words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecadeTest {

    @Test
    void testToStringFemale() {
        //given
        Decade decade = new Decade((short)32);
        String expected = "тридцать две";
        //when
        String actual = decade.toString(Number.Gender.FEMALE);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {
        //given
        Decade decade = new Decade((short)14);
        String expected = "четырнадцать";
        //when
        String actual = decade.toString(Number.Gender.FEMALE);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void largeNumberTestToString() {
        //given
        Decade decade = new Decade((short)10345);
        String expected = "сорок пять";
        //when
        String actual = decade.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testToStringZero() {
        //given
        Decade decade = new Decade((short)0);
        String expected = "";
        //when
        String actual = decade.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void negativeTestToString() {
        //given
        Decade decade = new Decade((short)-23);
        String expected = "";
        //when
        String actual = decade.toString();
        //then
        assertEquals(expected,actual);
    }
}
