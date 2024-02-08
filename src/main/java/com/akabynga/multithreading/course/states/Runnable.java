package com.akabynga.multithreading.course.states;

import com.akabynga.multithreading.course.ThreadUtil;

public class Runnable {

    public static void main(final String... args) {
        final Thread thread = new Thread(() -> ThreadUtil.showThreadState(Thread.currentThread()));
        ThreadUtil.showThreadState(thread);
        thread.start();
    }

}
