package com.mycollections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {
    @Test
    public void testThatEmptyCollectionSizeIsZero() {
        Assertions.assertEquals(0, new MyLinkedList<String>().size());
    }

    @Test
    public void testThatAfterAdding1ElementCollectionSizeIs1() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("item");

        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void testThatExceptionIsThrownForGetMethodWhenIndexIsOutOfBounds() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MyLinkedList<String>().get(0)
        );
    }

    @Test
    public void testThatExceptionIsThrownForRemoveMethodWhenIndexIsOutOfBounds() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MyLinkedList<String>().get(0)
        );
    }

    @Test
    public void testThatGetMethodWorksOkFor1ElementCollection() {
        MyLinkedList<String> list = new MyLinkedList<>();

        String expectedItem = "item";
        list.add(expectedItem);

        Assertions.assertEquals(expectedItem, list.get(0));
    }

    @Test
    public void testRemovingCenterElementFrom3ElementsCollection() {
        MyLinkedList<String> list = new MyLinkedList<>();

        for (int i = 0; i < 3; i++) {
            list.add("item-" + i);
        }

        list.remove(1);

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("item-0", list.get(0));
        Assertions.assertEquals("item-2", list.get(1));
    }

    @Test
    public void testRemovingFirstElementFrom3ElementsCollection() {
        MyLinkedList<String> list = new MyLinkedList<>();

        for (int i = 0; i < 3; i++) {
            list.add("item-" + i);
        }

        list.remove(0);

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("item-1", list.get(0));
        Assertions.assertEquals("item-2", list.get(1));
    }

    @Test
    public void testRemovingHeadNodeFrom3ElementsCollection() {
        MyLinkedList<String> list = new MyLinkedList<>();

        for (int i = 0; i < 3; i++) {
            list.add("item-" + i);
        }

        list.remove(2);

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("item-0", list.get(0));
        Assertions.assertEquals("item-1", list.get(1));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MyLinkedList<String>().get(2)
        );
    }

    @Test
    public void testClearMethod() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("item");
        list.clear();

        Assertions.assertEquals(0, list.size());
    }
}