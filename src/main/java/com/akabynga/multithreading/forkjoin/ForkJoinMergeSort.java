package com.akabynga.multithreading.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ForkJoinMergeSort {

    public static void main(String[] args) throws InterruptedException {

        int[] array = IntStream.range(0, 1_000_000).map(i -> ThreadLocalRandom.current().nextInt(1000)).toArray();
        System.out.println(Arrays.toString(array));

        ForkJoinPool pool = ForkJoinPool.commonPool();

        pool.invoke(new MergeSortAction(array));

        TimeUnit.SECONDS.sleep(10);
        System.out.println(Arrays.toString(array));
    }

}
