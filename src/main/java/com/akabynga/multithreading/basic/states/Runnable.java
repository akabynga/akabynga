package com.akabynga.multithreading.basic.states;

import com.akabynga.multithreading.basic.ThreadUtil;

public class Runnable {

    public static void main(final String... args) {
        final Thread thread = new Thread(() -> ThreadUtil.showThreadState(Thread.currentThread()));
        ThreadUtil.showThreadState(thread);
        thread.start();
    }

}
