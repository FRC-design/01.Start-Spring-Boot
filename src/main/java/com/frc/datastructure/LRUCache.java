package com.frc.datastructure;
import java.util.*;

/**
 * 由双向链表+哈希表组成， map数据中映射到链表里
 * 双向链表用来记录访问的顺序，尾部就是最后使用的元素
 */
class LRUCache {
    private Map<String, String> map;
    /**
     * 双向链表，删除一个节点不光要得到该节点本身的指针，也需要操作其前驱节点的指针，
     * 而双向链表才能支持直接查找前驱，保证操作的时间复杂度 O(1)
     */
    private Deque<String> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new LinkedList();
    }

    /**
     *取完数据，要更新一下元素在双向链表里的位置
     */
    public String get(String key) {
        if (!map.containsKey(key))
            return "no answer";
        String val = map.get(key);
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    /**
     *放数据，同时放到链表里，如果大于容量，删除链表尾端的元素
     */
    public void put(String key, String val) {
        if (map.containsKey(key)) {
            // 删除旧的节点，新元素插到头部
            cache.remove(map.get(key));
            // 更新 map 中对应的数据
        } else {
            if (capacity == cache.size()) {
                // 删除链表最后一个数据
                String element = cache.removeLast();
                map.remove(element);
            }
        }
        //添加到头部
        cache.addFirst(key);
        map.put(key, val);
    }

}