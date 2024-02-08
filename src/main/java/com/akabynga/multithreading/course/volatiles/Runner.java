package com.akabynga.multithreading.course.volatiles;

import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        final PrintingTask firstPrintingTask = new PrintingTask();
        final Thread firstPrintingThread = new Thread(firstPrintingTask);

        firstPrintingThread.start();

        final PrintingTask secondPrintingTask = new PrintingTask();
        final Thread secondPrintingThread = new Thread(secondPrintingTask);

        secondPrintingThread.start();

        final PrintingTask thirdPrintingTask = new PrintingTask();
        final Thread thirdPrintingThread = new Thread(thirdPrintingTask);

        thirdPrintingThread.start();

        TimeUnit.SECONDS.sleep(1);

        firstPrintingTask.setShouldPrint(false);
        secondPrintingTask.setShouldPrint(false);
        thirdPrintingTask.setShouldPrint(false);
        System.out.println("Printing should be stopped");

    }
}
