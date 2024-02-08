package com.akabynga.multithreading.course.daemon;

import java.util.concurrent.TimeUnit;

public class Runner {

    public static final String MESSAGE_MAIN_THREAD_FINISHED = "Main thread is finished.";

    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().isDaemon());

        Thread thread = new Thread(new Task());
        thread.start();

        System.out.println("Is daemon: " + thread.isDaemon());
        System.out.println(MESSAGE_MAIN_THREAD_FINISHED);
    }

    public static final class Task implements Runnable {
        private static final String MESSAGE = "I am working";
        private static final int DURATION_BETWEEN_MESSAGE_IN_SECONDS = 2;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(MESSAGE);
                    TimeUnit.SECONDS.sleep(DURATION_BETWEEN_MESSAGE_IN_SECONDS);
                }
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
