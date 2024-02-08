package com.akabynga.multithreading.course.reentrantlock.readwrite;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

// ReentrantLock 192726192
// ReentrantReadWriteLock 28540721
public class Runner {
    public static void main(String[] args) throws InterruptedException {

//        testCounter(CounterGuarderByLock::new);
        testCounter(CounterGuarderByReadWriteLock::new);
    }

    private static void testCounter(final Supplier<? extends AbstractCounter> counterFactory) throws InterruptedException {
        final AbstractCounter counter = counterFactory.get();

        final int amountOfThreadsGettingValue = 50;

        final ReadingValueTask[] readingValueTasks = createReadingTasks(counter, amountOfThreadsGettingValue);
        final Thread[] readingValueThreads = mapToThreads(readingValueTasks);

        final Runnable incrementingCounterTask = createIncrementingCounterTask(counter);
        final int amountOfThreadsIncrementingCounter = 2;
        final Thread[] incrementingValueThreads = createThreads(incrementingCounterTask, amountOfThreadsIncrementingCounter);

        startThreads(readingValueThreads);
        startThreads(incrementingValueThreads);

        TimeUnit.SECONDS.sleep(5);

        interruptThreads(readingValueThreads);
        interruptThreads(incrementingValueThreads);

        waitUntilFinish(readingValueThreads);

        final long totalAmountOfReads = findTotalAmountOfReads(readingValueTasks);

        System.out.printf("Amount of reading value: %d", totalAmountOfReads);

    }

    private static long findTotalAmountOfReads(final ReadingValueTask[] tasks) {
        return Arrays.stream(tasks).mapToLong(ReadingValueTask::getAmountOfReads).sum();
    }

    private static void waitUntilFinish(final Thread[] threads) {
        forEach(threads, Runner::waitUntilFinish);
    }

    private static void waitUntilFinish(final Thread thread) {
        try {
            thread.join();
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void interruptThreads(Thread[] threads) {
        forEach(threads, Thread::interrupt);
    }

    private static void startThreads(final Thread[] threads) {
        forEach(threads, Thread::start);
    }

    private static void forEach(final Thread[] threads, final Consumer<Thread> action) {
        Arrays.stream(threads).forEach(action);
    }

    private static Thread[] createThreads(final Runnable task, final int amountOfThreads) {
        return IntStream.range(0, amountOfThreads).mapToObj(i -> new Thread(task)).toArray(Thread[]::new);
    }

    private static Runnable createIncrementingCounterTask(final AbstractCounter counter) {
        return () -> {
            while (!Thread.currentThread().isInterrupted()) {
                incrementCounter(counter);
            }
        };
    }

    private static void incrementCounter(final AbstractCounter counter) {
        try {
            counter.increment();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static ReadingValueTask[] createReadingTasks(final AbstractCounter counter, final int amountOfTasks) {
        return IntStream.range(0, amountOfTasks)
                .mapToObj(i -> new ReadingValueTask(counter))
                .toArray(ReadingValueTask[]::new);
    }

    private static Thread[] mapToThreads(final Runnable[] tasks) {
        return Arrays.stream(tasks).map(Thread::new).toArray(Thread[]::new);
    }

    private static final class ReadingValueTask implements Runnable {

        private final AbstractCounter counter;
        private long amountOfReads;

        public ReadingValueTask(final AbstractCounter counter) {
            this.counter = counter;
        }

        public long getAmountOfReads() {
            return amountOfReads;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                counter.getValue();
                this.amountOfReads++;
            }
        }
    }
}
