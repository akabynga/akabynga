package com.akabynga.multithreading.basic.daemon;

import com.akabynga.multithreading.basic.ThreadUtil;

public class DaemonRunnerWithException {

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> ThreadUtil.showThreadDaemonStatus(Thread.currentThread()));
        thread.start();
        thread.setDaemon(true);
    }

}
