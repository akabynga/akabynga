package com.akabynga.multithreading.course.creating;

import java.util.stream.IntStream;

public class Runner {

    private static final int CREATING_THREADS_AMOUNT = 10;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("***********");

        final Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        thread.run();
        thread.start();

        System.out.println("***********");
        final Runnable taskDisplayingThreadName = () -> System.out.println(Thread.currentThread().getName());
        final Thread thread1 = new Thread(taskDisplayingThreadName);

        thread.run();

        System.out.println("***********");
        final Runnable taskCreatingThreads = () -> IntStream.range(0, CREATING_THREADS_AMOUNT)
                .forEach(i -> startThread(taskDisplayingThreadName));

        startThread(taskCreatingThreads);
    }

    private static void startThread(final Runnable runnable) {
        new Thread(runnable).start();
    }
}
