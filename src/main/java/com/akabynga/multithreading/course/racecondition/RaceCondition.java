package com.akabynga.multithreading.course.racecondition;

import java.util.stream.IntStream;

public class RaceCondition {
    private static int counter = 0;
    private static final int INCREMENT_AMOUNT_FIRST_THREAD = 500;
    private static final int INCREMENT_AMOUNT_SECOND_THREAD = 600;

    public static void main(final String... args) throws InterruptedException {

        final Thread firstThread = createIncrementCounterThread(INCREMENT_AMOUNT_FIRST_THREAD);
        final Thread secondThread = createIncrementCounterThread(INCREMENT_AMOUNT_SECOND_THREAD);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(counter);
    }

    private static Thread createIncrementCounterThread(final int incrementAmount) {
        return new Thread(() -> IntStream.range(0, incrementAmount).forEach(i -> counter++));
    }
}
