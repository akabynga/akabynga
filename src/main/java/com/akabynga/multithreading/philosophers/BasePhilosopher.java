package com.akabynga.multithreading.philosophers;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class BasePhilosopher extends Thread {

    protected final BaseFork leftFork;
    protected final BaseFork rightFork;

    public AtomicInteger eatCount = new AtomicInteger();

    protected BasePhilosopher(String name, BaseFork leftFork, BaseFork rightFork) {
        super(name);
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    protected void think() throws InterruptedException {
        if (Runner1.DEBUG) {
            System.out.println(Runner1.TIME_FORMATTER.format(LocalDateTime.now()) + ": " + Thread.currentThread().getName() + " is thinking");
        }
        if (Runner1.MAX_WAIT_MS > 0) {
            Thread.sleep(getRandomInt());
        }
    }

    protected void eat() throws InterruptedException {
        long t = System.nanoTime();
        if (Runner1.DEBUG) {
            System.out.println(Runner1.TIME_FORMATTER.format(LocalDateTime.now()) + ": " + Thread.currentThread().getName() + " is eating");
        }
        if (Runner1.MAX_WAIT_MS > 0) {
            Thread.sleep(getRandomInt());
        }
        eatCount.incrementAndGet();
    }

    private int getRandomInt() {
        return (int) (Math.random() * Runner1.MAX_WAIT_MS);
    }
}