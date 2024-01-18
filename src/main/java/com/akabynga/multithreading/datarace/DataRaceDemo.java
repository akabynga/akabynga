package com.akabynga.multithreading.datarace;

public class DataRaceDemo {
 
    static volatile int sharedValue;
 
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (sharedValue % 2 == 0) {
                        System.out.println("sharedValue = " + sharedValue);
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) sharedValue++;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}