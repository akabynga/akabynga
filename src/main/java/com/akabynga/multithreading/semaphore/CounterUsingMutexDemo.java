package com.akabynga.multithreading.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CounterUsingMutexDemo {
    public static void main(String[] args) throws InterruptedException {
        int count = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        CounterUsingMutex counter = new CounterUsingMutex();
        CountDownLatch latch = new CountDownLatch(count);
        IntStream.range(0, count).forEach(user -> executorService.execute(() -> {
            try {
                counter.increase(latch);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
//        Thread.sleep(2000);
        latch.await();
        executorService.shutdown();
        System.out.println(counter.hasQueuedThreads());
        System.out.println(counter.getCount());
    }
}
