package com.mycollections;

import java.util.Objects;

public class MyHashMap<K, V> {
    private MyNode[] table;
    private static final int DEFAULT_CAPACITY = 16;
    private int currentCapacity = DEFAULT_CAPACITY;

    class MyNode<K, V> {
        private int hash;
        private K key;
        private V value;
        private MyNode nextNode;

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

    public MyNode put(K key, V value) {
        MyNode duplicate = get(key);

        if (duplicate != null) {
            return duplicate;
        }

        float threshold = currentCapacity * 0.75f;

        if (threshold == size() + 1) {
            currentCapacity *= 2;
            MyNode[] newTable = new MyNode[currentCapacity];

            for (MyNode item : table) {
                if (item != null) {
                    do {
                        int index = item.hash & (currentCapacity - 1);

                        if (newTable[index] == null) {
                            newTable[index] = item;
                            item = item.nextNode;

                            newTable[index].nextNode = null;
                            continue;
                        }

                        MyNode existingItem = newTable[index];

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
            table[index] = new MyNode(hash, key, value);
            return null;
        }

        MyNode existingItem = table[index];

        while (existingItem.nextNode != null) {
            existingItem = existingItem.nextNode;
        }

        existingItem.nextNode = new MyNode(hash, key, value);
        return null;
    }

    public MyNode remove(K key) {
        MyNode nodeToRemove = get(key);

        if (nodeToRemove == null) {
            return null;
        }

        int hash = Objects.hashCode(key);
        int index = hash & (currentCapacity - 1);

        MyNode item = table[index];

        if (item == nodeToRemove) {
            table[index] = nodeToRemove.nextNode;
            return nodeToRemove;
        }

        while (item.nextNode != nodeToRemove) {
            item = item.nextNode;
        }

        item.nextNode = nodeToRemove.nextNode;

        return nodeToRemove;
    }

    public void clear() {
        table = new MyNode[0];
    }

    public int size() {
        int size = 0;

        for (MyNode item : table) {
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

    public MyNode get(K key) {
        int hash = Objects.hashCode(key);
        int index = hash & (currentCapacity - 1);

        MyNode item = table[index];

        if (item == null) {
            return null;
        }

        while (item.hash != hash || item.key != key) {
            item = item.nextNode;
            if (item == null) {
                return null;
            }
        }

        return item;
    }
}
