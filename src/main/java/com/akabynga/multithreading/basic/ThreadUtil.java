package com.akabynga.multithreading.basic;

import java.util.Arrays;

public class ThreadUtil {

    public static final String MESSAGE_TEMPLATE_THREAD_STATE = "%s : %s\n";

    public static void startThreads(final Thread[] threads) {
        Arrays.stream(threads).forEach(Thread::start);
    }

    public static void startThread(final Thread thread) {
        thread.start();
    }


    public static void showThreadState(final Thread thread) {
        System.out.printf(String.format(MESSAGE_TEMPLATE_THREAD_STATE, thread.getName(), thread.getState()));
    }

    public static void showThreadPriority(final Thread thread) {
        System.out.printf(String.format(MESSAGE_TEMPLATE_THREAD_STATE, thread.getName(), thread.getPriority()));
    }

    public static Thread startThread(final Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }

    private ThreadUtil() {
        throw new UnsupportedOperationException();
    }
}
