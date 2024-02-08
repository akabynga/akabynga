package com.akabynga.multithreading.course.states;

import com.akabynga.multithreading.course.ThreadUtil;

public class TerminatedRunnableRunnable {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> ThreadUtil.showThreadState(Thread.currentThread()));
        thread.start();
        thread.join();
        ThreadUtil.showThreadState(thread);

    }
}
