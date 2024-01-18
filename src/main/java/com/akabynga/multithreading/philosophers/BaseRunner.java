package com.akabynga.multithreading.philosophers;

import com.sun.tools.javac.Main;

public class BaseRunner {

    public static boolean DEBUG = true;
    public static int PHILOSOPHERS_COUNT = 5;
    public static int MAX_WAIT_MS = 1;
    public static int DINNER_DURATION_IN_MS = 10000;
    protected static Thread[] threads = new Thread[BaseRunner.PHILOSOPHERS_COUNT];

    protected static void waitMillis(long millis) {
        if (millis <= 0) {
            return;
        }
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected static void stopThreads(Thread[] threads) {
        for (Thread thread : threads) {
            if (!thread.isInterrupted()) {
                thread.interrupt();
            }
        }
        waitMillis(100);
    }
}