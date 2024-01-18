package com.akabynga.multithreading.cyclicbarier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static CyclicBarrier FerryBarrier;
    private static final int FerryBoat_size = 3;

    // �������������� ���������� �����
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                // �������� �� ��������� 
                System.out.println("\n�������� �����������");
                Thread.sleep(500);
                System.out.println("����� ���������� ����������\n");
            } catch (InterruptedException e) {
            }
        }
    }

    // ����� ����������
    public static class Car implements Runnable {
        private final int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("� ��������� �������� ���������� %d\n", carNumber);
                // ����� ������ await ��� ������� � 
                // �������; ����� ����������� � �������� 
                // ������� ��������� �������
                FerryBarrier.await();
                System.out.printf("���������� %d ��������� ��������\n", carNumber);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FerryBarrier = new CyclicBarrier(FerryBoat_size, new FerryBoat());
        for (int i = 1; i < 10; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }
}