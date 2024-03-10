package com.akabynga.faang.structure;

public class CustomStack<T> {

    private T[] stack;
    private int index;

    public void push(T item) {
        if (stack.length <= index) {
            grow();
        }
        stack[index++] = item;
    }

    private void grow() {
        T[] newArray = (T[]) new Object[stack.length * 2 + 1];
        System.arraycopy(stack, 0, newArray, 0, stack.length);
        stack = newArray;
    }

    public T pop() {
        T item = stack[--index];
        stack[index] = null;
        return item;
    }

    public T peek() {
        if (index <= 0) {
            return null;
        }
        return stack[index - 1];
    }
}
