package com.akabynga.leetcode.peekingiterator;

import java.util.List;

public class PeekingIteratorDemo {
    public static void main(String[] args) {
        PeekingIterator peekingIterator = new PeekingIterator(List.of(1, 2, 3, 4, 5).iterator());

        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());


//        while (peekingIterator.hasNext()) {
//            System.out.println(peekingIterator.next());
//        }
    }
}
