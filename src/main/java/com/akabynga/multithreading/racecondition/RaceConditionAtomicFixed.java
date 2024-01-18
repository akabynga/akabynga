package com.akabynga.multithreading.racecondition;

public class RaceConditionAtomicFixed {

    public static void main(String[] args) throws InterruptedException {

        AtomicSafeSequence ss = new AtomicSafeSequence();

        new Thread(process(ss)).start();
        new Thread(process(ss)).start();
        new Thread(process(ss)).start();
        new Thread(process(ss)).start();

    }

    public static Runnable process(AtomicSafeSequence ss) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                ss.getNext();
            }
            System.out.println("finished: " + ss.getValue());
        };
    }
}
