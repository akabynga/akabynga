package com.akabynga.multithreading.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BadAssumption {
    public static void main(String[] args) {
        ExecutorService exec = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
//        ExecutorService exec = Executors.newCachedThreadPool();
        if (exec instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) exec).setCorePoolSize(10);
            exec.shutdown();
        } else {
            throw new AssertionError("Oops, bad assumption");
        }
    }
}
