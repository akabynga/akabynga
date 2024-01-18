package com.akabynga.multithreading.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    private final static BlockingQueue<String> drop = new ArrayBlockingQueue<>(3);
    private static volatile boolean stop = false;

    private static final int[] consumerCounter = {0, 0, 0, 0, 0};

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            int counter = 0;
            while (!stop) {
                if (drop.offer("Person: " + ++counter)) {
                    System.out.println("Added person #" + counter);
                } else {
                    counter--;
                }
            }
        }, "Producer");
        producer.start();

        new Thread(getConsumer(1), "Consumer 1").start();
        new Thread(getConsumer(2), "Consumer 2").start();
        new Thread(getConsumer(3), "Consumer 3").start();
        new Thread(getConsumer(4), "Consumer 4").start();
        new Thread(getConsumer(5), "Consumer 5").start();


        new Thread(() -> {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(25000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            stop = true;
            System.out.println("End process: " + (System.currentTimeMillis() - start));
            int result = 0;
            for (int i = 0; i < consumerCounter.length; i++) {
                result += consumerCounter[i];
                System.out.println("Counter [" + (i + 1) + "]: " + consumerCounter[i]);
            }
            System.out.println("Total: " + result);
        }).start();
    }

    private static Runnable getConsumer(int i) {
        return () -> {
            while (!stop) {
                String person = drop.poll();
                if (person != null) {
                    consumerCounter[i - 1]++;
                    System.out.println("Processing person: " + person + " by " + Thread.currentThread().getName());
                }
            }
        };
    }
}
