package com.akabynga.multithreading.racecondition;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicSafeSequence {
    private final AtomicLong value = new AtomicLong(0);

    public long getNext() {
        return value.incrementAndGet();
    }

    public long getValue() {
        return value.get();
    }
}
