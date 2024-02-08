package com.akabynga.multithreading.course.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenNumberGenerator {

    private static final int GENERATION_DELTA = 2;
    private final AtomicInteger value = new AtomicInteger(0);

    public int generate() {
        return value.getAndAdd(GENERATION_DELTA);
    }

    public int getValue() {
        return value.intValue();
    }
}
