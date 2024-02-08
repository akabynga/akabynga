package com.akabynga.multithreading.course.semaphore;

import com.akabynga.multithreading.course.ThreadUtil;

public class SemaphoreRunner {
    public static void main(String[] args) {
        final int poolSize = 3;
        final ConnectionPool pool = new ConnectionPool(poolSize);

        final ConnectionPoolTask poolTask = new ConnectionPoolTask(pool);
        final int threadCount = 15;
        final Thread[] threads = ThreadUtil.createThreads(poolTask, threadCount);

        ThreadUtil.startThreads(threads);
    }
}
