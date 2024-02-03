package com.akabynga.multithreading.executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InvokerDemo {
    private static Runnable r = () -> {
        System.out.println("start runnable");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception");
        }
        System.out.println("Hello from runnable task!");
    };

    public static void main(String[] args) throws InterruptedException {
//        execute(new Invoker());
        execute(Executors.newFixedThreadPool(3));
        System.out.println("test");

    }

    public static void execute(ExecutorService executor) throws InterruptedException {
        long start = System.currentTimeMillis();

        executor.execute(r);
        executor.execute(r);
        executor.execute(r);
        executor.execute(r);
        executor.execute(r);
        System.out.println("between execution");
        executor.execute(r);
        System.out.println("after execution");

        executor.shutdown();
//        executor.execute(r);
//        executor.execute(r);

        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            List<Runnable> notFinished = executor.shutdownNow();

            long shutdown = System.currentTimeMillis();
            System.out.println("Shutdown: " + (shutdown - start) + " not finished: " + notFinished.size());
        }

//        System.out.println(executor.awaitTermination(10, TimeUnit.SECONDS));
//        boolean result = false;
//        while (!(result = executor.awaitTermination(5, TimeUnit.SECONDS))) {
//            Thread.sleep(100);
//            System.out.println(result);
//        }
        long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start));
    }
}
