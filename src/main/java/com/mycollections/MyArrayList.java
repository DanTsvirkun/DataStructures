package com.mycollections;

public class MyArrayList<E> {
    private E[] instance;
    private static final int DEFAULT_CAPACITY = 10;
    private int currentCapacity = DEFAULT_CAPACITY;
    private int index = -1;

    public MyArrayList(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("Size can't be less than 0");
        }

        if(size == 0) {
            instance = (E[]) new Object[DEFAULT_CAPACITY];
            return;
        }

        instance = (E[]) new Object[size];
        currentCapacity = size;
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void add(E value) {
        index++;
        instance[index] = value;

        if (index == currentCapacity - 1) {
            currentCapacity *= 2;
            E[] newInstance = (E[]) new Object[currentCapacity];

            System.arraycopy(instance, 0, newInstance, 0, size());

            instance = newInstance;
        }
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

    public E get(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        return instance[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add("item-" + i);
        }

        list.remove(1);

        System.out.println("size = " + list.size());
        System.out.println("item-0 = " + list.get(0));
        System.out.println("item-2 = " + list.get(1));
    }
}
