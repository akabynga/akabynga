package com.akabynga.multithreading.racecondition;

public class UnsafeSequence {

    private int value;

    public int getNext() {
        return value++;
    }

    public int getValue() {
        return value;
    }
}
