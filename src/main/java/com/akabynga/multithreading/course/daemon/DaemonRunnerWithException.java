package com.akabynga.multithreading.course.daemon;

import com.akabynga.multithreading.course.ThreadUtil;

public class DaemonRunnerWithException {

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> ThreadUtil.showThreadDaemonStatus(Thread.currentThread()));
        thread.start();
        thread.setDaemon(true);
    }

}
