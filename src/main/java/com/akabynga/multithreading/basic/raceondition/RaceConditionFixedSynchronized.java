package com.akabynga.multithreading.basic.raceondition;

import com.akabynga.multithreading.basic.ThreadUtil;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class RaceConditionFixedSynchronized {
    private static int firstCounter = 0;
    private static int secondCounter = 0;

    private static final Object LOCK_FIRST_COUNTER = new Object();
    private static final Object LOCK_SECOND_COUNTER = new Object();
    private static final int INCREMENT_AMOUNT_FIRST_COUNTER = 500;
    private static final int INCREMENT_AMOUNT_SECOND_COUNTER = 600;

    public static void main(final String... args) throws InterruptedException {

        final Thread firstThread = createIncrementCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER, i -> incrementFirstCounter());
        final Thread secondThread = createIncrementCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER, i -> incrementFirstCounter());
        final Thread threadThread = createIncrementCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER, i -> incrementSecondCounter());
        final Thread fourthThread = createIncrementCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER, i -> incrementSecondCounter());

        ThreadUtil.startThreads(firstThread, secondThread, threadThread, fourthThread);
        ThreadUtil.waitUntilAreCompletedThreads(firstThread, secondThread, threadThread, fourthThread);

        System.out.println(firstCounter);
        System.out.println(secondCounter);
    }

    private static Thread createIncrementCounterThread(final int incrementAmount,
                                                       final IntConsumer incrementingConsumer) {
        return new Thread(() -> IntStream.range(0, incrementAmount).forEach(incrementingConsumer));
    }

    private static void incrementFirstCounter() {
        synchronized (LOCK_FIRST_COUNTER) {
            firstCounter++;
        }
    }

    private synchronized static void incrementSecondCounter() {
        synchronized (LOCK_SECOND_COUNTER) {
            secondCounter++;
        }
    }
}
