package com.frc.sort;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class quickSortTest {

    @Test
    void positiveTest(){
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        quickSort sortInstance = new quickSort();
        sortInstance.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void instream(){
        IntStream.range(0, 10000).forEach(System.out::println);
    }

}