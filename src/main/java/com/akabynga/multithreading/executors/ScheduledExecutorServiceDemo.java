package com.akabynga.multithreading.executors;

import java.util.concurrent.*;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        execute(service);
    }

    public static void execute(ScheduledExecutorService service) {

//        service.scheduleWithFixedDelay(() -> {
//            System.out.println("test 3");
//
//        }, 0, 6, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(() -> {
            System.out.println("test 4");

        }, 0, 6, TimeUnit.SECONDS);

        Future<String> future = service.schedule(() -> {
            System.out.println("test 1");
            return "Hello World!";
        }, 5, TimeUnit.SECONDS);


        ScheduledFuture<?> scheduledFuture = service.schedule(() -> {
            System.out.println("test 2");
        }, 5, TimeUnit.SECONDS);


//        service.shutdown();

    }
}
