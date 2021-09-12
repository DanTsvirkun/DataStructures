package com.mycollections;

import java.util.Objects;

public class MyHashMap<K, V> {
    private MyNode<K, V>[] table;
    private static final int DEFAULT_CAPACITY = 16;
    private int currentCapacity = DEFAULT_CAPACITY;

    class MyNode<K, V> {
        private final int hash;
        private final K key;
        private final V value;
        private MyNode<K, V> nextNode;

        public MyNode(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;

            nextNode = null;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public MyHashMap() {
        table = new MyNode[DEFAULT_CAPACITY];
    }

    public MyNode<K, V> put(K key, V value) {
        float threshold = currentCapacity * 0.75f;

        if (threshold == size() + 1) {
            currentCapacity *= 2;
            MyNode<K, V>[] newTable = new MyNode[currentCapacity];

            for (MyNode<K, V> item : table) {
                if (item != null) {
                    do {
                        int index = item.hash & (currentCapacity - 1);

                        if (newTable[index] == null) {
                            newTable[index] = item;
                            item = item.nextNode;

                            newTable[index].nextNode = null;
                            continue;
                        }

                        MyNode<K, V> existingItem = newTable[index];

                        while (existingItem.nextNode != null) {
                            existingItem = existingItem.nextNode;
                        }

                        existingItem.nextNode = item;
                        item = item.nextNode;

                        existingItem.nextNode.nextNode = null;
                    } while (item != null);
                }
            }

            table = newTable;
        }

        int hash = Objects.hashCode(key);
        int index = hash & (currentCapacity - 1);

        if (table[index] == null) {
            table[index] = new MyNode<>(hash, key, value);
            return null;
        }

        MyNode<K, V> existingItem = table[index];

        while (existingItem.nextNode != null) {
            if (existingItem.key.equals(key)) {
                return existingItem;
            }

            existingItem = existingItem.nextNode;
        }

        existingItem.nextNode = new MyNode<>(hash, key, value);
        return null;
    }

    public MyNode<K, V> remove(K key) {
        int hash = Objects.hashCode(key);
        int index = hash & (currentCapacity - 1);

        MyNode<K, V> prevNode = null;
        MyNode<K, V> item = table[index];

        if (item == null) {
            return null;
        }

        if (item.key.equals(key)) {
            table[index] = item.nextNode;
            return item;
        }

        while (!item.key.equals(key)) {
            prevNode = item;
            item = item.nextNode;
        }

        prevNode.nextNode = item.nextNode;

        return item;
    }

    public void clear() {
        table = new MyNode[0];
    }

    public int size() {
        int size = 0;

        for (MyNode<K, V> item : table) {
            if (item != null) {
                size++;
                while (item.nextNode != null) {
                    item = item.nextNode;
                    size++;
                }
            }
        }

        return size;
    }

    public V get(K key) {
        int hash = Objects.hashCode(key);
        int index = hash & (currentCapacity - 1);

        MyNode<K, V> item = table[index];

        if (item == null) {
            return null;
        }

        while (item.hash != hash || !item.key.equals(key)) {
            item = item.nextNode;
            if (item == null) {
                return null;
            }
        }

        return item.value;
    }
}
