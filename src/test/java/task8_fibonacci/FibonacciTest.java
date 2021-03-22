package task8_fibonacci;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testGetFibonacciRowFromTo() {
        //given
        Fibonacci f = new Fibonacci();
        int from = 20;
        int to = 120;
        List<Integer> expected = Arrays.asList(21,34,55,89);
        //when
        List<Integer> actual = f.getFibonacciRow(from,to);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testVoidGetFibonacciRow() {
        //given
        Fibonacci f = new Fibonacci();
        int from = 35;
        int to = 52;
        List<Integer> expected = new ArrayList<>();
        //when
        List<Integer> actual = f.getFibonacciRow(from,to);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testGetFibonacciRowCountOfDigits() {
        //given
        Fibonacci f = new Fibonacci();
        int countOfDigit = 5;
        List<Integer> expected = Arrays.asList(10946, 17711, 28657, 46368, 75025);
        //when
        List<Integer> actual = f.getFibonacciRow(countOfDigit);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testGetFibonacciRowCountOfDigits1() {
        //given
        Fibonacci f = new Fibonacci();
        int countOfDigit = 1;
        List<Integer> expected = Arrays.asList(0,1,1,2,3,5,8);
        //when
        List<Integer> actual = f.getFibonacciRow(countOfDigit);
        //then
        assertEquals(expected,actual);
    }
}