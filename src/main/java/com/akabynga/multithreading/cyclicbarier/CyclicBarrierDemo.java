package com.akabynga.multithreading.cyclicbarier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            // ...
            System.out.println("All previous tasks are completed");
        });

        Thread t1 = new Thread(new CyclicBarrierTask(cyclicBarrier), "T1");
        Thread t2 = new Thread(new CyclicBarrierTask(cyclicBarrier), "T2");
        Thread t3 = new Thread(new CyclicBarrierTask(cyclicBarrier), "T3");

        if (!cyclicBarrier.isBroken()) {
            t1.start();
            t2.start();
            t3.start();
        }

    }
}
