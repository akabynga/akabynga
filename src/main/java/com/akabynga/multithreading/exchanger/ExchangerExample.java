package com.akabynga.multithreading.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    // �������� ��������� ��������
    private static Exchanger<Letter> EXCHANGER;

    static String msg1 = "��������� %s ������� ������ : %s, %s\n";
    static String msg2 = "��������� %s ������ �� %s � %s\n";
    static String msg3 = "��������� %s ������� � ����� �\n";
    static String msg4 = "��������� %s ������� ������ ��� %s\n";
    static String msg5 = "��������� %s ������ � %s : %s, %s\n";


    public static class Postman implements Runnable {
        private final String id;
        private final String departure;
        private final String destination;
        private final Letter[] letters;

        public Postman(String id, String departure, String destination, Letter[] letters) {
            this.id = id;
            this.departure = departure;
            this.destination = destination;
            this.letters = letters;
        }

        @Override
        public void run() {
            try {
                System.out.printf(msg1, id, letters[0], letters[1]);
                System.out.printf(msg2, id, departure, destination);
                Thread.sleep((long) (Math.random() * 5000) + 5000);
                System.out.printf(msg3, id);
                // �������������� ������ ��� 
                // ������ ��������
                letters[1] = EXCHANGER.exchange(letters[1]);
                // ����� ��������
                System.out.printf(msg4, id, destination);
                Thread.sleep(1000 + (long) (Math.random() * 5000));
                System.out.printf(msg5, id, destination, letters[0], letters[1]);
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Letter {
        private final String address;

        public Letter(final String address) {
            this.address = address;
        }

        public String toString() {
            return address;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EXCHANGER = new Exchanger<Letter>();
        // ������������ �����������
        Letter[] posts1 = new Letter[2];
        Letter[] posts2 = new Letter[2];

        posts1[0] = new Letter("�.� - ������");
        posts1[1] = new Letter("�.� - ���� ������������");
        posts2[0] = new Letter("�.� - ����� ������");
        posts2[1] = new Letter("�.� - ������");
        // ����������� �����������
        new Thread(new Postman("a", "�", "�", posts1)).start();
        Thread.sleep(100);
        new Thread(new Postman("�", "�", "�", posts2)).start();
    }
}