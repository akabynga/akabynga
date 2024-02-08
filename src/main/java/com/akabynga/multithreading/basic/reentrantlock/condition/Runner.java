package com.akabynga.multithreading.basic.reentrantlock.condition;

import com.akabynga.multithreading.basic.ThreadUtil;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) {
        final BoundedBuffer<Integer> boundedBuffer = new BoundedBuffer<>(5);

        final Runnable producingTask = () -> IntStream.iterate(0, i -> i + 1).forEach(i -> {
            try {
                boundedBuffer.put(i);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        final Thread producingThread = new Thread(producingTask);

        final Runnable consumingTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    boundedBuffer.take();
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        final Thread consumingThread = new Thread(consumingTask);

        ThreadUtil.startThreads(producingThread, consumingThread);

    }

}
