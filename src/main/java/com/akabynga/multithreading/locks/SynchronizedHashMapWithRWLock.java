package com.akabynga.multithreading.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizedHashMapWithRWLock {

    private static final Map<String, String> syncHashMap = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void put(String key, String value) throws InterruptedException {

        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " writing");
            syncHashMap.put(key, value);
            TimeUnit.MILLISECONDS.sleep(1000);
        } finally {
            writeLock.unlock();
        }

    }

    public String get(String key) {
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " reading");
            return syncHashMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public String remove(String key) {
        try {
            writeLock.lock();
            return syncHashMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    public boolean containsKey(String key) {
        try {
            readLock.lock();
            return syncHashMap.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

    boolean isReadLockAvailable() {
        return readLock.tryLock();
    }

    public static void main(String[] args) throws InterruptedException {

        final int threadCount = 3;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        SynchronizedHashMapWithRWLock object = new SynchronizedHashMapWithRWLock();

        service.execute(new Thread(new Writer(object), "Writer"));
        service.execute(new Thread(new Reader(object), "Reader1"));
        service.execute(new Thread(new Reader(object), "Reader2"));

        service.shutdown();
    }

    private static class Reader implements Runnable {

        SynchronizedHashMapWithRWLock object;

        Reader(SynchronizedHashMapWithRWLock object) {
            this.object = object;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                object.get("key" + i);
            }
        }
    }

    private static class Writer implements Runnable {

        SynchronizedHashMapWithRWLock object;

        public Writer(SynchronizedHashMapWithRWLock object) {
            this.object = object;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    object.put("key" + i, "value" + i);
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}