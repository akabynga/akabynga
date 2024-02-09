package com.akabynga.multithreading.course.racecondition;

import com.akabynga.multithreading.course.ThreadUtil;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class SynchronizedDemo {
    private static final int INCREMENT_AMOUNT_FIRST_COUNTER = 500;
    private static final int INCREMENT_AMOUNT_SECOND_COUNTER = 600;

    public static void main(final String... args) throws InterruptedException {

        final Counter firstCounter = new Counter();
        final Counter secondCounter = new Counter();

        final Thread firstThread = createIncrementCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER, i -> firstCounter.increment());
        final Thread secondThread = createIncrementCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER, i -> firstCounter.increment());
        final Thread threadThread = createIncrementCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER, i -> secondCounter.increment());
        final Thread fourthThread = createIncrementCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER, i -> secondCounter.increment());

        ThreadUtil.startThreads(firstThread, secondThread, threadThread, fourthThread);
        ThreadUtil.waitUntilAreCompletedThreads(firstThread, secondThread, threadThread, fourthThread);

        System.out.println(firstCounter.counter);
        System.out.println(secondCounter.counter);
    }

    private static final class Counter {
        private int counter;

        public synchronized void increment() {
            synchronized (this) {
                this.counter++;
            }
        }
    }

    private static Thread createIncrementCounterThread(final int incrementAmount,
                                                       final IntConsumer incrementingConsumer) {
        return new Thread(() -> IntStream.range(0, incrementAmount).forEach(incrementingConsumer));
    }
}
