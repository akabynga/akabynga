package com.akabynga.multithreading.threadfactory;

import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class DemoThreadFactory implements ThreadFactory {

    private int threadId;
    private String name;

    public DemoThreadFactory(String name) {
        this.threadId = 1;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + threadId);
        System.out.printf("Created new thread with id: %d and name: %s\n", threadId, t.getName());
        threadId++;
        return t;
    }

    public static void main(String[] args) {
        DemoThreadFactory factory = new DemoThreadFactory("My factory");

        IntStream.range(0, 10).forEach(value ->
                factory.newThread(() -> System.out.println("Locked And Loaded")).start()
        );
    }
}
