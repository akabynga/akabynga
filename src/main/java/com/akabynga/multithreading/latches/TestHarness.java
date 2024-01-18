package com.akabynga.multithreading.latches;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) {
                }
            });
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        return System.nanoTime() - start;
    }

    public static void main(String[] args) throws InterruptedException {
        long test = timeTasks(5, () -> {
            System.out.println("Done: " + Thread.currentThread().getName());
        });
        System.out.println(test);
    }
}