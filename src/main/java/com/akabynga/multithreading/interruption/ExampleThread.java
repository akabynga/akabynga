package com.akabynga.multithreading.interruption;

public class ExampleThread extends Thread {
    public void run() {
        try {
            while (!isInterrupted()) {
//            while (true) {
                // Do some work
                Thread.sleep(1000); // ����������� ��������
            }
        } catch (InterruptedException e) {
            // ��������� ����������
            System.out.println("Interruption");
        }
    }
}