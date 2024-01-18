package com.akabynga.multithreading.sync;

import com.akabynga.multithreading.utils.GuardedBy;
import com.akabynga.multithreading.utils.ThreadSafe;

@ThreadSafe
public final class Counter {
    @GuardedBy("this")
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }
}