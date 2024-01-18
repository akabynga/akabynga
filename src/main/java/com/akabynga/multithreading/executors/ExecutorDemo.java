package com.akabynga.multithreading.executors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
    private static final ExecutorService exec = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        Runnable[] test = {ExecutorDemo::handleRequest, ExecutorDemo::handleRequest1, ExecutorDemo::handleRequest2};
        List<Future<?>> list = new ArrayList<>();
        Random rand = new Random();
        int i = 0;
        do {
            Future<?> f = exec.submit(test[rand.nextInt(3) % 3]);
            list.add(f);
            f.cancel(false);
        } while (i++ < 10);
        exec.shutdown();
        System.out.println("Shutdown");
        Thread.sleep(1000);
        for (Future<?> f : list) {
            System.out.println(f.get());
        }
    }

    public static void handleRequest() {
        System.out.println("Handling request 0 " + Thread.currentThread().getName() + " " + Thread.currentThread().getClass().getName() + "@" + Integer.toHexString(Thread.currentThread().hashCode()));
    }

    public static void handleRequest1() {
        System.out.println("Handling request 1 " + Thread.currentThread().getName() + " " + Thread.currentThread().getClass().getName() + "@" + Integer.toHexString(Thread.currentThread().hashCode()));
    }

    public static void handleRequest2() {
        System.out.println("Handling request 2 " + Thread.currentThread().getName() + " " + Thread.currentThread().getClass().getName() + "@" + Integer.toHexString(Thread.currentThread().hashCode()));
    }
}
