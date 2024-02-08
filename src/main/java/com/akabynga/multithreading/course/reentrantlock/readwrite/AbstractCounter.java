package com.akabynga.multithreading.course.reentrantlock.readwrite;

import java.util.OptionalLong;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public abstract class AbstractCounter {
    private long value;


    public final OptionalLong getValue() {
        getReadLock().lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            return OptionalLong.of(this.value);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            return OptionalLong.empty();
        } finally {
            getReadLock().unlock();
        }
    }

    public final void increment() {
        getWriteLock().lock();
        try {
            this.value++;
        } finally {
            getWriteLock().unlock();
        }
    }

    protected abstract Lock getReadLock();

    protected abstract Lock getWriteLock();
}
