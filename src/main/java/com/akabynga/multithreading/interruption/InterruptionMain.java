package com.akabynga.multithreading.interruption;

public class InterruptionMain {
    public static void main(String[] args) throws InterruptedException {
        ExampleThread thread = new ExampleThread();
        thread.start();

        Thread.sleep(1000); // Ждем 5 секунд

        thread.interrupt(); // Прерываем поток
    }
}