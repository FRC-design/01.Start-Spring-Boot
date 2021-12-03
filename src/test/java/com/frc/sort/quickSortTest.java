package com.frc.sort;

import org.junit.jupiter.api.Test;

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

}