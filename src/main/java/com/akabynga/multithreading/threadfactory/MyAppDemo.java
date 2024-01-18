package com.akabynga.multithreading.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyAppDemo {
    public static void main(String[] args) throws InterruptedException {


        ExecutorService service = Executors.newFixedThreadPool(2, new MyThreadFactory("Test"));

        int number = 0;
        while (number < 1000) {
            service.submit(() -> System.out.println("test " + Thread.currentThread().getName()));
            number++;
        }
        service.shutdown();
        System.out.println("----------------------------------------------------------------------> shutdown!!!");
        service.awaitTermination(1000, TimeUnit.SECONDS);
        System.out.println("----------------------------------------------------------------------> termination!!!");
        System.out.println(MyAppThread.getThreadsAlive());
        System.out.println(MyAppThread.getThreadsCreated());
    }
}
