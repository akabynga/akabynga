package com.akabynga.multithreading.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

class CounterUsingMutex {

    private final Semaphore mutex;
    private int count;

    CounterUsingMutex() {
        mutex = new Semaphore(1);
        count = 0;
    }

    void increase(CountDownLatch latch) throws InterruptedException {
        mutex.acquire();
        System.out.println("Thread start: " + Thread.currentThread().getName());
        this.count = this.count + 1;
//        Thread.sleep(1000);
        System.out.println("Thread end: " + Thread.currentThread().getName());
        mutex.release();
        latch.countDown();
    }

    int getCount() {
        return this.count;
    }

    boolean hasQueuedThreads() {
        return mutex.hasQueuedThreads();
    }
}