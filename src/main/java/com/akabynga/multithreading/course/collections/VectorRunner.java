package com.akabynga.multithreading.course.collections;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class VectorRunner {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        final Runnable addingTask = () -> addIfNotExist(vector, 4);
        final Thread firstThread = new Thread(addingTask);
        final Thread secondThread = new Thread(addingTask);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(vector);
    }

    private static void addIfNotExist(final List<Integer> values, final Integer element) {
        if (!values.contains(element)) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            values.add(element);
        }
    }
}
