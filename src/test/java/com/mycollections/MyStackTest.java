package com.mycollections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyStackTest {
    @Test
    public void testThatEmptyCollectionSizeIsZero() {
        Assertions.assertEquals(0, new MyStack<String>().size());
    }

    @Test
    public void testThatAfterAdding1ElementCollectionSizeIs1() {
        MyStack<String> stack = new MyStack<>();
        stack.push("item");

        Assertions.assertEquals(1, stack.size());
    }

    @Test
    public void testThatExceptionIsThrownForRemoveMethodWhenIndexIsOutOfBounds() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MyStack<String>().remove(0)
        );
    }

    @Test
    public void testRemovingFrom3ElementsCollection() {
        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i < 3; i++) {
            stack.push("item-" + i);
        }

        stack.remove(2);

        Assertions.assertEquals(2, stack.size());
        Assertions.assertEquals("item-1", stack.peek());
    }

    @Test
    public void testPopMethod() {
        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i < 3; i++) {
            stack.push("item-" + i);
        }

        Assertions.assertEquals("item-2", stack.pop());
        Assertions.assertEquals("item-1", stack.peek());
        Assertions.assertEquals(2, stack.size());
    }

    @Test
    public void testPeekMethod() {
        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i < 3; i++) {
            stack.push("item-" + i);
        }

        Assertions.assertEquals("item-2", stack.peek());
    }

    @Test
    public void testClearMethod() {
        MyStack<String> stack = new MyStack<>();
        stack.push("item");
        stack.clear();

        Assertions.assertEquals(0, stack.size());
    }

    @Test
    public void testThatAfterAdding10ElementsCollectionCapacityIsIncreased() {
        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i <= 10; i++) {
            stack.push("item-" + i);
        }

        Assertions.assertEquals(11, stack.size());
    }
}