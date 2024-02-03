package com.akabynga.multithreading.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class WaitingWorker implements Runnable {

    private final List<String> outputScraper;
    private final CountDownLatch readyThreadCounter;
    private final CountDownLatch callingThreadBlocker;
    private final CountDownLatch completedThreadCounter;

    public WaitingWorker(
            List<String> outputScraper,
            CountDownLatch readyThreadCounter,
            CountDownLatch callingThreadBlocker,
            CountDownLatch completedThreadCounter) {

        this.outputScraper = outputScraper;
        this.readyThreadCounter = readyThreadCounter;
        this.callingThreadBlocker = callingThreadBlocker;
        this.completedThreadCounter = completedThreadCounter;
    }

    @Override
    public void run() {
        readyThreadCounter.countDown();
        try {
            callingThreadBlocker.await();
            doSomeWork();
            outputScraper.add("Counted down");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            completedThreadCounter.countDown();
        }
    }

    private void doSomeWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}