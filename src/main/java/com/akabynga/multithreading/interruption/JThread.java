package com.akabynga.multithreading.interruption;

class JThread extends Thread {

    JThread(String name) {
        super(name);
    }

    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1; // счетчик циклов
        while (!isInterrupted()) {
            System.out.println("Loop " + counter++ + " ");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
                interrupt();
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}