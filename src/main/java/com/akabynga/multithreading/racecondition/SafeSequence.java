package com.akabynga.multithreading.racecondition;

public class SafeSequence {

    private int value;

    public synchronized int getNext() {
        return value++;
    }

    public synchronized int getValue() {
        return value;
    }
}
