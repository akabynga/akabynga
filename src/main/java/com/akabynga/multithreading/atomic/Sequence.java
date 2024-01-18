package com.akabynga.multithreading.atomic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Sequence implements Runnable {
    Thread thread;
    int id;
    int count;
    SequenceGenerator sg;
    List<BigInteger> sequence = new ArrayList<BigInteger>();
    boolean printed = false;

    Sequence(final int id, final int count,
             SequenceGenerator sg) {
        this.count = count;
        this.id = id;
        this.sg = sg;
        thread = new Thread(this);

        System.out.println("������ ����� " + id);
        thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                sequence.add(sg.next());
                Thread.sleep((long) (
                        (Math.random() * 2 + 1) * 30));
            }
        } catch (InterruptedException e) {
            System.out.println("����� " + id
                    + " �������");
        }
        System.out.print("����� " + id + " ��������\n\r");
        printSequence();
    }

    public void printSequence() {
        if (printed)
            return;
        StringBuilder tmp = new StringBuilder("[");
        for (int i = 0; i < sequence.size(); i++) {
            if (i > 0)
                tmp.append(", ");
            StringBuilder nb = new StringBuilder(String.valueOf(sequence.get(i)));
            while (nb.length() < 9)
                nb.insert(0, " ");
            tmp.append(nb);
        }
        tmp.append("]");
        System.out.println("������������������ ������ "
                + id + " : " + tmp);
        printed = true;
    }
}