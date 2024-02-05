package com.akabynga.multithreading.basic.states;

import com.akabynga.multithreading.basic.ThreadUtil;

public class TerminatedRunnableRunnable {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> ThreadUtil.showThreadState(Thread.currentThread()));
        thread.start();
        thread.join();
        ThreadUtil.showThreadState(thread);

    }
}
