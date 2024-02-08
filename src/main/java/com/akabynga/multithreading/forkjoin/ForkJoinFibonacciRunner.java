package com.akabynga.multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinFibonacciRunner {

    public static void main(String[] args) {

        ForkJoinFibonacci task = new ForkJoinFibonacci(50);
        new ForkJoinPool().invoke(task);

        System.out.println(task.getNumber());

    }

}