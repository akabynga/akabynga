package com.akabynga.multithreading.interruption;

public class InterruptionMain {
    public static void main(String[] args) throws InterruptedException {
        ExampleThread thread = new ExampleThread();
        thread.start();

        Thread.sleep(1000); // ���� 5 ������

        thread.interrupt(); // ��������� �����
    }
}