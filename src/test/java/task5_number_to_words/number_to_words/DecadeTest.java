package task5_number_to_words.number_to_words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecadeTest {

    @Test
    void testToStringFemale() {
        //given
        Decade decade = new Decade(32);
        String expected = "тридцать две";
        //when
        String actual = decade.toString(Word.Sex.FEMALE);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {
        //given
        Decade decade = new Decade(14);
        String expected = "четырнадцать";
        //when
        String actual = decade.toString(Word.Sex.FEMALE);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void largeNumberTestToString() {
        //given
        Decade decade = new Decade(10345);
        String expected = "сорок пять";
        //when
        String actual = decade.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testToStringZero() {
        //given
        Decade decade = new Decade(0);
        String expected = "";
        //when
        String actual = decade.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void negativeTestToString() {
        //given
        Decade decade = new Decade(-23);
        String expected = "";
        //when
        String actual = decade.toString();
        //then
        assertEquals(expected,actual);
    }
}
