package com.akabynga.multithreading.delayedqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayQueueConsumer implements Runnable {
    private final BlockingQueue<DelayObject> queue;
    private final int numberOfElementsToTake;
    private AtomicInteger numberOfConsumedElements = new AtomicInteger();


    public DelayQueueConsumer(final BlockingQueue<DelayObject> queue, final Integer numberOfElementsToTake) {
        this.queue = queue;
        this.numberOfElementsToTake = numberOfElementsToTake;
    }

    @Override
    public void run() {
//        for (int i = 0; i < numberOfElementsToTake; i++) {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                DelayObject object = queue.take();
                numberOfConsumedElements.incrementAndGet();
                System.out.println("Consumer take: " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

//        }
    }

    public int getNumberOfElementsToTake() {
        return numberOfConsumedElements.get();
    }
}