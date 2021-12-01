package com.springboot.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dev1Test {


    @Test
    void search() {
        binarySearch search = new binarySearch();
        int[] nums = {1,2,3,4,5,6,7,9};
        assertEquals(-1,search.search(nums,11));
        assertNotEquals(100,search.search(nums,11));

    }


}