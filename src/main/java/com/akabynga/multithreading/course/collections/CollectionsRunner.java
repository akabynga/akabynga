package com.akabynga.multithreading.course.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

public class CollectionsRunner {

    public static void main(String[] args) throws InterruptedException {
//        final List<Integer> values = new ArrayList<>(); // wrong result
//        final List<Integer> values = new Vector<>();
        final List<Integer> values = Collections.synchronizedList(new ArrayList<>());
        final Runnable task = () -> IntStream.range(0, 1000).forEach(values::add);

        final Thread firstThread = new Thread(task);
        final Thread secondThread = new Thread(task);
        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(values.size());
    }
}
