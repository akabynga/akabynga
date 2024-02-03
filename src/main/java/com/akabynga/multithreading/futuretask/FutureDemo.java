package com.akabynga.multithreading.futuretask;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<String> future = service.submit(() -> {
            Thread.sleep(10000l);
            System.out.println("done?");
            return "Hello world!";
        });
        while (future.isDone() && !future.isCancelled()) {
            if (future.isDone() && !future.isCancelled()) {
                try {
                    String str = future.get();
                    System.out.println(str);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        String str = future.get(11, TimeUnit.SECONDS);
        System.out.println(str);

        service.shutdown();
    }
}
