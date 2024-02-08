package com.akabynga.multithreading.course.volatiles;

import java.util.concurrent.TimeUnit;

public class PrintingTask implements Runnable {

    private volatile boolean shouldPrint = true;

    public void setShouldPrint(final boolean shouldPrint) {
        this.shouldPrint = shouldPrint;
    }

    @Override
    public void run() {
        try {
            while (this.shouldPrint) {
                System.out.println("I'm working");
                TimeUnit.MILLISECONDS.sleep(0);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
