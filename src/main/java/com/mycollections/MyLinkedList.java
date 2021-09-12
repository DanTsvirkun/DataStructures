package com.mycollections;

public class MyLinkedList<E> {
    private MyNode head = null;

    class MyNode {
        private final E data;
        private MyNode prevNode;
        private MyNode nextNode;

        public MyNode(E data) {
            this.data = data;

            if (head == null) {
                head = this;
                prevNode = null;
                nextNode = null;
                return;
            }

            head.nextNode = this;
            prevNode = head;
            nextNode = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public boolean add(E data) {
        head = new MyNode(data);
        return true;
    }

    public MyNode remove(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        MyNode nodeToRemove = head;
        int iterator = size();

        while (iterator - 1 != index) {
            nodeToRemove = nodeToRemove.prevNode;
            iterator--;
        }

        if (nodeToRemove.prevNode == null && nodeToRemove.nextNode != null) {
            nodeToRemove.nextNode.prevNode = null;
        }

        if (nodeToRemove.nextNode == null && nodeToRemove.prevNode != null) {
            nodeToRemove.prevNode.nextNode = null;
            head = nodeToRemove.prevNode;
        }

        if (nodeToRemove.nextNode != null && nodeToRemove.prevNode != null) {
            nodeToRemove.prevNode.nextNode = nodeToRemove.nextNode;
            nodeToRemove.nextNode.prevNode = nodeToRemove.prevNode;
        }

        return head;
    }

    public void clear() {
        head = null;
    }

    public int size() {
        MyNode currentNode = head;
        int size = 0;

        while (currentNode != null) {
            currentNode = currentNode.prevNode;
            size++;
        }

        return size;
    }

    public E get(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        MyNode nodeToGet = head;
        int iterator = size();

        while (iterator - 1 != index) {
            nodeToGet = nodeToGet.prevNode;
            iterator--;
        }

        return nodeToGet.data;
    }
}