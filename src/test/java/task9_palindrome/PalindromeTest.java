package task9_palindrome;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeTest {

    @Test
    void getPalindromesTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("41564651531564650045005550500"));
        String expected = "[646, 56465, 1564651, 515, 00, 5005, 55, 555, 05550, 505, 050]";
        //when
        String actual = palindrome.getPalindromes();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void getPalindromesEmptyTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("415465106532"));
        String expected = "0";
        //when
        String actual = palindrome.getPalindromes();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void toStringTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("1234437"));
        String expected = "[44, 3443]";
        //when
        String actual = palindrome.toString();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void toStringEmptyTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("123567"));
        String expected = "[]";
        //when
        String actual = palindrome.toString();
        //then
        assertEquals(expected,actual);
    }
}