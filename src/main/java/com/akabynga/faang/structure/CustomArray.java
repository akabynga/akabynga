package com.akabynga.faang.structure;

public class CustomArray<T> {

    private int length;
    private T[] data;

    public CustomArray() {
        this.length = 0;
        this.data = (T[]) new Object[1];
    }

    public T get(int index) {
        return this.data[index];
    }

    public int push(T item) {
        if (length >= data.length) {
            grow();
        }
        this.data[length++] = item;
        return this.length;
    }

    private void grow() {
        T[] temp = (T[]) new Object[data.length * 2 + 1];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public T pop() {
        T lastItem = this.data[this.length - 1];
        data[--length] = null;

        return lastItem;
    }

    public T delete(int index) {
        T item = this.data[index];

        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        length--;
        return item;
    }

    public int size() {
        return length;
    }


    public static void main(String[] args) {
        CustomArray<Integer> array = new CustomArray<>();

        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);

        System.out.println(array.delete(0));
        System.out.println("----");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
//        while (array.size() > 0) {
//            System.out.println(array.delete(0));
//        }
    }
}
