package com.mycollections;

public class MyStack<E> {
    private E[] instance;
    private static final int DEFAULT_CAPACITY = 10;
    private int currentCapacity = DEFAULT_CAPACITY;
    private int index = -1;

    public MyStack() {
        instance = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public E push(E value) {
        index++;
        instance[index] = value;

        if (index == currentCapacity - 1) {
            currentCapacity *= 2;
            E[] newInstance = (E[]) new Object[currentCapacity];

            System.arraycopy(instance, 0, newInstance, 0, size());

            instance = newInstance;
        }

        return value;
    }

    public E remove(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        E itemToDelete = instance[index];

        instance[index] = null;
        System.arraycopy(instance, index + 1, instance, index, size() - 1 - index);

        this.index--;

        instance[this.index + 1] = null;

        return itemToDelete;
    }

    public void clear() {
        instance = (E[]) new Object[0];
        index = -1;
        currentCapacity = DEFAULT_CAPACITY;
    }

    public int size() {
        return index + 1;
    }

    public E peek() {
        if (size() == 0) {
            return null;
        }

        return instance[size() - 1];
    }

    public E pop() {
        if (size() == 0) {
            return null;
        }

        E firstItem = instance[size() - 1];

        instance[size() - 1] = null;
        this.index--;

        return firstItem;
    }
}
