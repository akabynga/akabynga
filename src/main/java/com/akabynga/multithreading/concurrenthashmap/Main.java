package com.akabynga.multithreading.concurrenthashmap;

public final class Main {
    public static void main(final String[] args) {
        CounterTestUtil.test(new SingleThreadLetterCounter());
        CounterTestUtil.test(new MultiThreadLetterCounter(5));
    }
}