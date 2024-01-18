package com.akabynga.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final int COUNT_CONTROL_PLACES = 5;
    private static final int COUNT_RIDERS = 7;
    // ����� ���� ��������
    private static volatile boolean[] CONTROL_PLACES;

    // �������
    private static Semaphore SEMAPHORE = null;

    public static class Rider implements Runnable {
        private final int ruderNum;

        public Rider(int ruderNum) {
            this.ruderNum = ruderNum;
        }

        @Override
        public void run() {
            System.out.printf("������� %d ������� � ���� ��������\n", ruderNum);
            try {
                // ������ ����������
                SEMAPHORE.acquire();
                System.out.printf("\t������� %d ��������� �������  ���������� �����������\n", ruderNum);
                int controlNum = -1;
                // ���� ��������� ����� � 
                // �������� � �����������
                synchronized (CONTROL_PLACES) {
                    for (int i = 0; i < COUNT_CONTROL_PLACES; i++)
                        // ���� �� ��������� �����������?
                        if (CONTROL_PLACES[i]) {
                            // �������� �����
                            CONTROL_PLACES[i] = false;
                            controlNum = i;
                            System.out.printf("\t\t������� %d ������� � ����������� % d.\n", ruderNum, i);
                            break;
                        }
                }

                // ����� �������� ������ � ��������
                Thread.sleep((int) (Math.random() * 10 + 1) * 1000);

                // ������������ ����� ��������
                synchronized (CONTROL_PLACES) {
                    CONTROL_PLACES[controlNum] = true;
                }

                // ������������ �������
                SEMAPHORE.release();
                System.out.printf("������� %d �������� ��������\n", ruderNum);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // ���������� ���������� ���� ��������
        CONTROL_PLACES = new boolean[COUNT_CONTROL_PLACES];
        // ����� ���� �������� [true-��������,false-������]
        for (int i = 0; i < COUNT_CONTROL_PLACES; i++)
            CONTROL_PLACES[i] = true;
        /*


         *  ���������� ������� �� ���������� ����������� :
         *  - ���������� ���������� 5
         *  - ���� ����������� fair=true (�������
         *                             first_in-first_out)
         */
        SEMAPHORE = new Semaphore(CONTROL_PLACES.length, true);

        for (int i = 1; i <= COUNT_RIDERS; i++) {
            new Thread(new Rider(i)).start();
            Thread.sleep(400);
        }
    }
}