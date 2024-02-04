package com.akabynga.leetcode.peekingiterator;// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;
    private Integer current;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (this.current == null) {
            this.current = iterator.next();
        }
        return this.current;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (this.current != null) {
            var val = this.current;
            this.current = null;
            return val;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return this.current != null || iterator.hasNext();
    }
}