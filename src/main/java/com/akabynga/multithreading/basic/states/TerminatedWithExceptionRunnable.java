package com.akabynga.multithreading.basic.states;

import com.akabynga.multithreading.basic.ThreadUtil;

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
