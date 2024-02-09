package com.akabynga.multithreading.delayedqueue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DelayQueueProducer implements Runnable {

    private final BlockingQueue<DelayObject> queue;
    private final int numberOfElementsToProduce;
    private final int delayOfEachProducedMessageMilliseconds;

    public DelayQueueProducer(final BlockingQueue<DelayObject> queue,
                              final int numberOfElementsToProduce,
                              final int delayOfEachProducedMessageMilliseconds) {
        this.queue = queue;
        this.numberOfElementsToProduce = numberOfElementsToProduce;
        this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
    }

    @Override
    public void run() {

//        for (int i = 0; i < numberOfElementsToProduce; i++) {
        while (!Thread.currentThread().isInterrupted()) {
            DelayObject object
                    = new DelayObject(
                    UUID.randomUUID().toString(), delayOfEachProducedMessageMilliseconds);
            try {
                queue.put(object);
                System.out.printf("Put object: %s. Queue size: %d\n", object, queue.size());
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
//        }
    }
}