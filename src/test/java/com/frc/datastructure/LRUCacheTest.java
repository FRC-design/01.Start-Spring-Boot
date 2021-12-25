package com.frc.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
    @Test
    void testLRU(){
        LRUCache lru = new LRUCache(3);
        lru.put("1","1");
        lru.put("2","2");
        lru.put("3","3");
        lru.put("4","4");
        System.out.println(lru.get("1"));
        System.out.println(lru.get("2"));

    }

}