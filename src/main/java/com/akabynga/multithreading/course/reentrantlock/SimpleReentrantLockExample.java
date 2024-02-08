package com.akabynga.multithreading.course.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class SimpleReentrantLockExample {
    public static void main(String[] args) {

        final EvenNumberGenerator evenNumberGenerator = new EvenNumberGenerator();

        final Runnable generatingTask = () -> IntStream.range(0, 100).forEach(i -> System.out.println(evenNumberGenerator.generate()));

        final Thread firstThread = new Thread(generatingTask);
        firstThread.start();

        final Thread secondThread = new Thread(generatingTask);
        secondThread.start();

        final Thread thirdThread = new Thread(generatingTask);
        thirdThread.start();

    }

    private static final class EvenNumberGenerator {
        private int previousGenerated;
        private final ReentrantLock lock = new ReentrantLock();

        public EvenNumberGenerator() {
            this.previousGenerated = -2;
        }

        public int generate() {
            try {
                return lock.tryLock(1, TimeUnit.SECONDS) ? this.onSuccessAcquireLock() : this.onFailAcquireLock();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException();
            }
        }

        private int onSuccessAcquireLock() {
            try {
                return this.previousGenerated += 2;
            } finally {
                lock.unlock();
            }
        }

        private int onFailAcquireLock() {
            System.out.printf("Thread '%s' didn't acquire lock.\n", Thread.currentThread().getName());
            throw new RuntimeException();
        }
    }
}
