package com.akabynga.multithreading.course.reentrantlock;

import com.akabynga.multithreading.course.ThreadUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) {

        final Counter counter = new Counter();
        final int incrementAmount = 10;
        final int decrementAmount = 10;

        Thread firstThread = new Thread(createTaskDoingOperationOnCounter(counter, i -> counter.increment(), incrementAmount));
        Thread secondThread = new Thread(createTaskDoingOperationOnCounter(counter, i -> counter.decrement(), decrementAmount));

        ThreadUtil.startThreads(firstThread, secondThread);
        ThreadUtil.waitUntilAreCompletedThreads(firstThread, secondThread);
        System.out.printf("Counter value '%d'.", counter.getValue());
    }

    private static Runnable createTaskDoingOperationOnCounter(final Counter counter,
                                                              final IntConsumer operation,
                                                              final int times) {
        return () -> {
            counter.lock();
            try {
                IntStream.range(0, times).forEach(operation);
            } finally {
                counter.unlock();
            }
        };
    }

    private static final class Counter {
        private final Lock lock = new ReentrantLock();
        private int value;

        public void lock() {
            lock.lock();
            printMessageWithCurrentThreadNameArgument("Thread '%s' locked counter.\n");
        }

        public void increment() {
            this.value++;
            printMessageWithCurrentThreadNameArgument("Thread '%s' incremented counter.\n");
        }

        public void decrement() {
            this.value--;
            printMessageWithCurrentThreadNameArgument("Thread '%s' decrement counter.\n");
        }

        public void unlock() {
            printMessageWithCurrentThreadNameArgument("Thread '%s' unlocking counter.\n");
            this.lock.unlock();
        }

        public int getValue() {
            return this.value;
        }

        private static void printMessageWithCurrentThreadNameArgument(String message) {
            System.out.printf(message, Thread.currentThread().getName());
        }
    }
}
