package com.akabynga.multithreading.racecondition;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {

        UnsafeSequence us = new UnsafeSequence();

        new Thread(process(us)).start();
        new Thread(process(us)).start();
        new Thread(process(us)).start();
        new Thread(process(us)).start();
    }


    public static Runnable process(UnsafeSequence us) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                us.getNext();
            }
            System.out.println("finished: " + us.getValue());
        };
    }
}
