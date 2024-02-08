package com.akabynga.multithreading.course.states;

import com.akabynga.multithreading.course.ThreadUtil;

public class TerminatedWithExceptionRunnable {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> {
            throw new RuntimeException();
        });
        thread.start();
        thread.join();
        ThreadUtil.showThreadState(thread);
    }
}
