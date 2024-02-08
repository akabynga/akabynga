package com.akabynga.multithreading.course.factory;

import com.akabynga.multithreading.course.ThreadUtil;

import java.util.concurrent.ThreadFactory;

public class Runner {


    public static void main(String[] args) throws InterruptedException {

        final ThreadFactory threadFactory = new DaemonThreadWithUncaughtExceptionHandlerFactory();

        final Thread firstThread = threadFactory.newThread(new Task());
        final Thread secondThread = threadFactory.newThread(new Task());

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();
    }


    private static final class Task implements Runnable {

        private static final String EXCEPTION_MESSAGE = "I'm working";

        @Override
        public void run() {
            ThreadUtil.showThreadDaemonStatus(Thread.currentThread());
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }
}