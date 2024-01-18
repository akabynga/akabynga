package com.akabynga.multithreading.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SquareCalculatorDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        isDoneTest();
//        timeOutTest();
//        cancelTest();
        oneMoreTest();
    }

    private static void oneMoreTest() throws InterruptedException, ExecutionException {
        SquareCalculator squareCalculator = new SquareCalculator();

        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

        squareCalculator.shutdown();
    }

    private static void cancelTest() {
        SquareCalculator calculator = new SquareCalculator();
        try {
            Future<Integer> future = calculator.calculate(10);
            boolean canceled = future.cancel(true);
            System.out.println(canceled);
        } finally {
            calculator.shutdown();
        }
    }

    private static void timeOutTest() throws ExecutionException, InterruptedException, TimeoutException {
        SquareCalculator calculator = new SquareCalculator();
        try {
            Future<Integer> future = calculator.calculate(10);
            Integer result = future.get(10, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } finally {
            calculator.shutdown();
        }
    }

    private static void isDoneTest() throws InterruptedException, ExecutionException, TimeoutException {
        SquareCalculator calculator = new SquareCalculator();
        Future<Integer> future = calculator.calculate(10);

        while (!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = future.get();
        System.out.println(result);
        calculator.shutdown();
    }
}
