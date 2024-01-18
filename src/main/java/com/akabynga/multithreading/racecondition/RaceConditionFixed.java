package com.akabynga.multithreading.racecondition;

public class RaceConditionFixed {

    public static void main(String[] args) throws InterruptedException {

        SafeSequence ss = new SafeSequence();

        new Thread(process(ss)).start();
        new Thread(process(ss)).start();
        new Thread(process(ss)).start();
        new Thread(process(ss)).start();

    }

    public static Runnable process(SafeSequence ss) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                ss.getNext();
            }
            System.out.println("finished: " + ss.getValue());
        };
    }
}
