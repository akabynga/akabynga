package com.akabynga.multithreading.interruption;

public class ExampleThread extends Thread {
    public void run() {
        try {
            while (!isInterrupted()) {
//            while (true) {
                // Do some work
                Thread.sleep(1000); // Блокирующая операция
            }
        } catch (InterruptedException e) {
            // Обработка прерывания
            System.out.println("Interruption");
        }
    }
}