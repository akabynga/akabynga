package com.akabynga.multithreading.basic.daemon;

import com.akabynga.multithreading.basic.ThreadUtil;

import java.util.concurrent.TimeUnit;

public class DaemonRunner {

    public static void main(String[] args) throws InterruptedException {
        final Thread firstDaemonThread = new Thread(() -> {
            try {
                ThreadUtil.showThreadDaemonStatus(Thread.currentThread());
                final Thread secondDaemonThread = new Thread(() -> ThreadUtil.showThreadDaemonStatus(Thread.currentThread()));
                secondDaemonThread.start();
                secondDaemonThread.join();
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        firstDaemonThread.setDaemon(true);
        firstDaemonThread.start();
        firstDaemonThread.join();
        TimeUnit.SECONDS.sleep(5);
    }


}
