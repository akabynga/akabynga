package com.akabynga.patterns.adapter.enumeration;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationAdapter<E> implements Enumeration<E> {

    private Iterator<E> iterator;

    public EnumerationAdapter(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public E nextElement() {
        return iterator.next();
    }
}
