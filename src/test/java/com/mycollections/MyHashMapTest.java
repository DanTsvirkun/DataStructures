package com.mycollections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashMapTest {
    @Test
    public void testThatEmptyCollectionSizeIsZero() {
        Assertions.assertEquals(0, new MyHashMap<String, Integer>().size());
    }

    @Test
    public void testThatAfterAdding1ElementCollectionSizeIs1() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        hashMap.put("item", 0);

        Assertions.assertEquals(1, hashMap.size());
    }

    @Test
    public void testThatNullIsReturnedForGetMethodWhenKeyDoesNotExist() {
        Assertions.assertNull(
                new MyHashMap<String, Integer>().get("item")
        );
    }

    @Test
    public void testThatGetMethodWorksOkFor1ElementCollection() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        hashMap.put("item", 0);

        Assertions.assertEquals(0, hashMap.get("item"));
    }

    @Test
    public void testRemovingFrom3ElementsCollection() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();

        for (int i = 0; i < 3; i++) {
            hashMap.put("item-" + i, i);
        }

        hashMap.remove("item-0");

        Assertions.assertEquals(2, hashMap.size());
        Assertions.assertNull(hashMap.get("item-0"));
    }

    @Test
    public void testClearMethod() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        hashMap.put("item", 0);
        hashMap.clear();

        Assertions.assertEquals(0, hashMap.size());
    }

    @Test
    public void testThatAfterAdding16ElementsCollectionCapacityIsIncreased() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();

        for (int i = 0; i <= 16; i++) {
            hashMap.put("item-" + i, i);
        }

        Assertions.assertEquals(17, hashMap.size());
    }
}