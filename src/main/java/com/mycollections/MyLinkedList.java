package com.mycollections;

public class MyLinkedList<E> {
    private MyNode head = null;
    private MyNode tail = null;

    class MyNode {
        private final E data;
        private MyNode prevNode;
        private MyNode nextNode;

        public MyNode(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public boolean add(E data) {
        MyNode newNode = new MyNode(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }

        return true;
    }

    public MyNode remove(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        MyNode nodeToRemove;

        if (index == 0) {
            nodeToRemove = head;

            head = head.nextNode;
            if (head == null) tail = null;

            return nodeToRemove;
        }

        MyNode prevNode = head;

        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.nextNode;
        }

        nodeToRemove = prevNode.nextNode;
        prevNode.nextNode = prevNode.nextNode.nextNode;

        if (prevNode.nextNode == null) {
            tail = prevNode;
        }

        return nodeToRemove;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public int size() {
        MyNode currentNode = head;
        int size = 0;

        while (currentNode != null) {
            currentNode = currentNode.nextNode;
            size++;
        }

        return size;
    }

    public E get(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        MyNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }

        return current.data;
    }
}