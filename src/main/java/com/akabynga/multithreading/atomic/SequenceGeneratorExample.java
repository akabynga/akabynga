package com.akabynga.multithreading.atomic;

import java.util.ArrayList;
import java.util.List;

public class SequenceGeneratorExample {
    public static void main(String[] args) {
        SequenceGenerator sg = new SequenceGenerator();
        List<Sequence> sequences = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sequence seq = new Sequence(i + 1, 3, sg);
            sequences.add(seq);
        }
        System.out.println("\n������ �������������������\n");
        int summa;
        // �������� ���������� �������
        do {
            summa = 0;
            for (Sequence sequence : sequences) {
                if (!sequence.thread.isAlive()) {
                    sequence.printSequence();
                    summa++;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        } while (summa < sequences.size());
        System.out.println("\n\n������ ������� ���������");
        System.exit(0);
    }
}