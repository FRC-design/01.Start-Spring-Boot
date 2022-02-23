package com.frc.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mergeSortTest {


    @Test
    public void positiveTest1() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort sort = new MergeSort();
        sort.sortArray(actual);
        assertArrayEquals(expected, actual);
    }
}