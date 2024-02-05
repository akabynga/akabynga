package com.akabynga.multithreading.basic.sleep;

import com.akabynga.multithreading.basic.ThreadUtil;

import java.util.stream.IntStream;

public class Runner {

    private static final int FROM_NUMBER_FIRST_THREAD = 1;
    private static final int TO_NUMBER_FIRST_THREAD = 500;
    private static final int FROM_NUMBER_SECOND_THREAD = 501;
    private static final int TO_NUMBER_SECOND_THREAD = 1000;

    private static final int TIME_WAITING_IN_MILLIS = 1000;

    private static final String TEMPLATE_MESSAGE_THREAD_NAME_AND_NUMBER = "%s : %d\n";

    public static void main(final String... args) throws InterruptedException {

        final TaskSummingNumbers firstTask = new TaskSummingNumbers(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIRST_THREAD);
        final TaskSummingNumbers secondTask = new TaskSummingNumbers(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);

        waitForTasksFinished(ThreadUtil.startThread(firstTask), ThreadUtil.startThread(secondTask));

        final int result = firstTask.getResultNumber() + secondTask.getResultNumber();
        printThreadNameAndNumber(result);
    }

    private static void waitForTasksFinished(Thread... threads) throws InterruptedException {
        for (final Thread thread : threads) {
            thread.join();
        }
    }

    private static TaskSummingNumbers startSubTask(final int fromNumber, final int toNumber) {
        final TaskSummingNumbers subtask = new TaskSummingNumbers(fromNumber, toNumber);
        ThreadUtil.startThread(subtask);
        return subtask;
    }

    private static void printThreadNameAndNumber(final int number) {
        System.out.printf(TEMPLATE_MESSAGE_THREAD_NAME_AND_NUMBER, Thread.currentThread().getName(), number);
    }

    private static final class TaskSummingNumbers implements Runnable {

        private static final int INITIAL_VALUE_RESULT_NUMBER = 0;

        private final int fromNumber;
        private final int toNumber;

        private int resultNumber;

        public TaskSummingNumbers(final int fromNumber, final int toNumber) {
            this.fromNumber = fromNumber;
            this.toNumber = toNumber;
            this.resultNumber = INITIAL_VALUE_RESULT_NUMBER;
        }

        public final int getResultNumber() {
            return this.resultNumber;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(this.fromNumber, this.toNumber).forEach(i -> this.resultNumber += i);
            printThreadNameAndNumber(this.resultNumber);
        }
    }

}
