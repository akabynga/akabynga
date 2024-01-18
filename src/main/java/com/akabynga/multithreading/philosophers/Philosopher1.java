package com.akabynga.multithreading.philosophers;

import java.util.concurrent.atomic.AtomicBoolean;

public class Philosopher1 extends BasePhilosopher {

    public final AtomicBoolean stopped = new AtomicBoolean();

    public Philosopher1(String name, BaseFork leftFork, BaseFork rightFork) {
        super(name, leftFork, rightFork);
    }

    @Override
    public void run() {
        try {
            while (!stopped.get()) {
                think();
                synchronized (leftFork) {
                    leftFork.take();
                    synchronized (rightFork) {
                        rightFork.take();
                        eat();
                        rightFork.put();
                        leftFork.put();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        }
    }

    public void terminate(){
        stopped.set(true);
    }
}
