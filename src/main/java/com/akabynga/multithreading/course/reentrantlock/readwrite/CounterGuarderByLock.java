package com.akabynga.multithreading.course.reentrantlock.readwrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class CounterGuarderByLock extends AbstractCounter {

    private final Lock lock = new ReentrantLock();

    @Override
    protected Lock getReadLock() {
        return lock;
    }

    @Override
    protected Lock getWriteLock() {
        return lock;
    }
}
