package com.akabynga.multithreading.course.priority;

import com.akabynga.multithreading.course.ThreadUtil;

public class Runner {


    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        ThreadUtil.showThreadPriority(Thread.currentThread());

        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        ThreadUtil.showThreadPriority(Thread.currentThread());

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        ThreadUtil.showThreadPriority(Thread.currentThread());

        final Thread thread = new Thread(() -> ThreadUtil.showThreadPriority(Thread.currentThread()));
        thread.start();

//        Thread.currentThread().setPriority(11);
//        ThreadUtil.showThreadPriority(Thread.currentThread());
    }
}
