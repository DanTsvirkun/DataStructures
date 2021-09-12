package com.mycollections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    @Test
    public void testThatEmptyCollectionSizeIsZero() {
        Assertions.assertEquals(0, new MyQueue<String>().size());
    }

    @Test
    public void testThatAfterAdding1ElementCollectionSizeIs1() {
        MyQueue<String> queue = new MyQueue<>();
        queue.add("item");

        Assertions.assertEquals(1, queue.size());
    }

    @Test
    public void testThatFalseIsReturnedForRemoveMethodWhenIndexIsOutOfBounds() {
        MyQueue<String> queue = new MyQueue<>();

        assertFalse(queue.remove(0));
    }

    @Test
    public void testPeekMethod() {
        MyQueue<String> queue = new MyQueue<>();

        for (int i = 0; i < 3; i++) {
            queue.add("item-" + i);
        }

        Assertions.assertEquals("item-0", queue.peek());
    }

    @Test
    public void testPollMethod() {
        MyQueue<String> queue = new MyQueue<>();

        for (int i = 0; i < 3; i++) {
            queue.add("item-" + i);
        }

        Assertions.assertEquals("item-0", queue.poll());
        Assertions.assertEquals("item-1", queue.peek());
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    public void testRemovingFrom3ElementsCollection() {
        MyQueue<String> queue = new MyQueue<>();

        for (int i = 0; i < 3; i++) {
            queue.add("item-" + i);
        }

        queue.remove(0);

        Assertions.assertEquals(2, queue.size());
        Assertions.assertEquals("item-1", queue.peek());
    }

    @Test
    public void testClearMethod() {
        MyQueue<String> queue = new MyQueue<>();
        queue.add("item");
        queue.clear();

        Assertions.assertEquals(0, queue.size());
    }

    @Test
    public void testThatAfterAdding11ElementsCollectionCapacityIsIncreased() {
        MyQueue<String> queue = new MyQueue<>();

        for (int i = 0; i <= 11; i++) {
            queue.add("item-" + i);
        }

        Assertions.assertEquals(12, queue.size());
    }
}