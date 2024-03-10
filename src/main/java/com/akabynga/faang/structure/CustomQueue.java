package com.akabynga.faang.structure;

public class CustomQueue<T> {

    private Node tail;
    private int size;


    public T peek() {
        return tail.val;
    }

    public void enqueue(T item) {
        if (tail == null) {
            tail = new Node(item);
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
        size++;
    }

    public T dequeue() {
        T temp = tail.val;
        tail = tail.prev;
        size--;
        return temp;
    }

    private class Node {
        private Node next;
        private Node prev;
        private final T val;

        public Node(T val) {
            this.val = val;
        }
    }
}
