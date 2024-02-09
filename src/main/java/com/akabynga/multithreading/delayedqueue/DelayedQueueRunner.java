package com.akabynga.multithreading.delayedqueue;

import java.util.concurrent.*;

public class DelayedQueueRunner {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        BlockingQueue<DelayObject> queue = new DelayQueue<>();
        int numberOfElementsToProduce = 2;
        int delayOfEachProducedMessageMilliseconds = 5000;
        DelayQueueConsumer consumer = new DelayQueueConsumer(
                queue, numberOfElementsToProduce);
        DelayQueueProducer producer = new DelayQueueProducer(
                queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);
        DelayQueueProducer producer1 = new DelayQueueProducer(
                queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);
        // when
        executor.submit(producer);
        executor.submit(producer1);
        executor.submit(consumer);

        // then
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();

        System.out.println(consumer.getNumberOfElementsToTake() + " " + numberOfElementsToProduce);
    }
}
