package task9_palindrome;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class PalindromeTest {

    @Test
    void getPalindromesSmallTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("1234437"));
        HashSet<String> expected = new HashSet<>(Arrays.asList("44", "3443"));
        //when
        HashSet<String> actual = palindrome.getPalindromes();
        //then
        assertIterableEquals(expected, actual);
    }

    @Test
    void getPalindromesBigTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("41564651531564650045005550500"));
        HashSet<String> expected = new HashSet<>(Arrays.asList(
                "646", "56465", "1564651", "515", "00", "5005", "55", "555", "05550", "505", "050"
        ));
        //when
        HashSet<String> actual = palindrome.getPalindromes();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getPalindromesEmptyTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("415465106532"));
        //when
        HashSet<String> actual = palindrome.getPalindromes();
        //then
        assertEquals(new HashSet<String>(), actual);
    }

    @Test
    void toStringTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("415646"));
        String expected = "[646]";
        //when
        String actual = palindrome.toString();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void toStringEmptyTest() {
        //given
        Palindrome palindrome = new Palindrome(new BigInteger("123567"));
        String expected = "[]";
        //when
        String actual = palindrome.toString();
        //then
        assertEquals(expected, actual);
    }
}