package com.mycollections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyArrayListTest {
    @Test
    public void testThatExceptionIsThrownForConstructorWhenCapacityIsLessThan0() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MyArrayList<String>(-1)
        );
    }

    @Test
    public void testThatEmptyCollectionSizeIsZero() {
        Assertions.assertEquals(0, new MyArrayList<String>().size());
    }

    @Test
    public void testThatAfterAdding1ElementCollectionSizeIs1() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("item");

        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void testThatExceptionIsThrownForGetMethodWhenIndexIsOutOfBounds() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MyArrayList<String>().get(0)
        );
    }

    @Test
    public void testThatExceptionIsThrownForRemoveMethodWhenIndexIsOutOfBounds() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MyArrayList<String>().remove(0)
        );
    }

    @Test
    public void testThatGetMethodWorksOkFor1ElementCollection() {
        MyArrayList<String> list = new MyArrayList<>();

        String expectedItem = "item";
        list.add(expectedItem);

        Assertions.assertEquals(expectedItem, list.get(0));
    }

    @Test
    public void testRemovingFrom3ElementsCollection() {
        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add("item-" + i);
        }

        list.remove(1);

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("item-0", list.get(0));
        Assertions.assertEquals("item-2", list.get(1));
    }

    @Test
    public void testClearMethod() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("item");
        list.clear();

        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testThatAfterAdding10ElementsCollectionCapacityIsIncreased() {
        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 0; i <= 10; i++) {
            list.add("item-" + i);
        }

        Assertions.assertEquals(11, list.size());
    }
}