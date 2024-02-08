package com.akabynga.multithreading.course.states;

import com.akabynga.multithreading.course.ThreadUtil;

public class SleepRunnable {

    private static final int AMOUNT_MILLISECONDS_TO_SLEEP_IN_MAIN_THREAD = 1000;
    private static final int AMOUNT_MILLISECONDS_TO_JOIN_IN_THREAD_ON_MAIN_THREAD = 2000;

    public static void main(String[] args) throws InterruptedException {
        final Thread mainThread = Thread.currentThread();
        final Thread thread = new Thread(() -> {
            try {
                mainThread.join();
                ThreadUtil.showThreadState(Thread.currentThread());
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread.start();
        Thread.sleep(AMOUNT_MILLISECONDS_TO_SLEEP_IN_MAIN_THREAD);
        ThreadUtil.showThreadState(thread);
    }
}
