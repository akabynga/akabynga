package com.akabynga.multithreading._experiments;

import java.util.concurrent.TimeUnit;

public class ThreadInterruption {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(routine());
        t.start();


        TimeUnit.SECONDS.sleep(5);
        t.interrupt();
        // t.stop(); // bad approach
    }


    private static Runnable routine() {
        return () -> {
            int i = 0;
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(100);
                    System.out.println("Hello form thread" + i++);
                }
            } catch (InterruptedException e) {
                System.out.println("INTERRUPTED");
                Thread.currentThread().interrupt();
            }
        };
    }
}
