package com.akabynga.faang.structure;

import java.util.Comparator;

public class CustomPriorityQueue<T> {

    private static final int DEFAULT_SIZE = 10;
    private T[] heap;
    private Comparator<T> comparator;

    private int size = 0;

    public CustomPriorityQueue(Comparator<T> comparator) {
        this.heap = (T[]) new Object[DEFAULT_SIZE];
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return heap[0];
    }

    public int push(T value) {
        if (size >= heap.length) {
            grow();
        }
        heap[size++] = value;
        siftUp();
        return size;
    }

    private void siftUp() {
        int nodeIndex = size - 1;

        while (nodeIndex > 0 && compare(nodeIndex, parent(nodeIndex)) < 0) {
            swap(nodeIndex, parent(nodeIndex));
            nodeIndex = parent(nodeIndex);
        }
    }

    // remove root
    public T pop() {
        if (size == 0) {
            return null;
        }
        T root = heap[0];
        if (size > 1) {
            swap(0, size - 1);
        }
        heap[--size] = null;
        siftDown();
        return root;
    }

    private void siftDown() {
        int nodeIndex = 0;

        while ((leftChild(nodeIndex) < size &&
                compare(leftChild(nodeIndex), nodeIndex) < 0)
                || (rightChild(nodeIndex) < size &&
                compare(rightChild(nodeIndex), nodeIndex) < 0)) {

            int greaterNodeIndex = rightChild(nodeIndex) < size &&
                    compare(rightChild(nodeIndex), leftChild(nodeIndex)) < 0 ?
                    rightChild(nodeIndex) : leftChild(nodeIndex);
            swap(greaterNodeIndex, nodeIndex);
            nodeIndex = greaterNodeIndex;
        }
    }

    private int parent(int index) {
        return (int) Math.ceil((double) (index - 1) / 2);
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private void swap(int from, int to) {
        T temp = heap[from];
        heap[from] = heap[to];
        heap[to] = temp;
    }

    private int compare(int a, int b) {
        return comparator.compare(heap[a], heap[b]);
    }

    private void grow() {
        T[] newArray = (T[]) new Object[heap.length * 2 + 1];
        System.arraycopy(heap, 0, newArray, 0, heap.length);
        heap = newArray;
    }
}
