package com.akabynga.collections.iterator;

import java.util.Iterator;

public class Box<T> implements Iterable<T> {

    private T[] array;
    public int index;


    public Box(T[] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
