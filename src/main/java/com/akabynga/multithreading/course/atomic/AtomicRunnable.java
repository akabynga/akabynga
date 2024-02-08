package com.akabynga.multithreading.course.atomic;

import com.akabynga.multithreading.course.ThreadUtil;

import java.util.stream.IntStream;

public class AtomicRunnable {
    public static void main(String[] args) {
        final EvenNumberGenerator generator = new EvenNumberGenerator();

        final int taskGenerationCounts = 10000;
        final Runnable generatingTask = () -> IntStream.range(0, taskGenerationCounts).forEach(i -> generator.generate());

        final int amountOfGenerationThreads = 5;
        final Thread[] generatingThreads = createThreads(generatingTask, amountOfGenerationThreads);

        ThreadUtil.startThreads(generatingThreads);
        ThreadUtil.waitUntilAreCompletedThreads(generatingThreads);

        final int expectedGeneratorValue = amountOfGenerationThreads * taskGenerationCounts * 2;
        final int actualGeneratorValue = generator.getValue();

        if (expectedGeneratorValue != actualGeneratorValue) {
            throw new RuntimeException(String.format("Expected is %d but was %d", expectedGeneratorValue, actualGeneratorValue));
        }
        System.out.println(expectedGeneratorValue);
    }

    private static Thread[] createThreads(final Runnable task, final int amountOfThreads) {
        return IntStream.range(0, amountOfThreads).mapToObj(i -> new Thread(task)).toArray(Thread[]::new);
    }
}
