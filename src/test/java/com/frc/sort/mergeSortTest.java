package com.frc.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mergeSortTest {
    @Test
    public void positiveTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        mergeSort.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }
}