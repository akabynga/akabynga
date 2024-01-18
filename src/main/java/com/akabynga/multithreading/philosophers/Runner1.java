package com.akabynga.multithreading.philosophers;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Runner1 {

    public static final boolean DEBUG = true;
    public static final int MAX_WAIT_MS = 2000;
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("hh-mm-ss.n");

    public static void main(String[] args) throws InterruptedException {
        BaseFork fork1 = new BaseFork(1);
        BaseFork fork2 = new BaseFork(2);
        BaseFork fork3 = new BaseFork(3);
        BaseFork fork4 = new BaseFork(4);
        BaseFork fork5 = new BaseFork(5);

        Philosopher1 ph1 = new Philosopher1("Sokratis", fork1, fork5);
        Philosopher1 ph2 = new Philosopher1("Platon", fork1, fork2);
        Philosopher1 ph3 = new Philosopher1("Buddy", fork2, fork3);
        Philosopher1 ph4 = new Philosopher1("Pythagoras", fork3, fork4);
        Philosopher1 ph5 = new Philosopher1("Zenon", fork4, fork5);

        List<Philosopher1> philosophers = new ArrayList<>();
        philosophers.add(ph1);
        philosophers.add(ph2);
        philosophers.add(ph3);
        philosophers.add(ph4);
        philosophers.add(ph5);

        for (Philosopher1 philosopher : philosophers) {
            philosopher.start();
        }
        Thread.currentThread().join(10000);
        for (Philosopher1 philosopher : philosophers) {
            philosopher.terminate();
        }
        Thread.currentThread().join(5000);

        for (Philosopher1 philosopher : philosophers) {
            System.out.println(philosopher.getName() + " count: " + philosopher.eatCount);
        }


    }
}
