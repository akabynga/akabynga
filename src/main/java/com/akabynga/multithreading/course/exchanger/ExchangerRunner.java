package com.akabynga.multithreading.course.exchanger;

import java.util.Queue;
import java.util.concurrent.Exchanger;

public class ExchangerRunner {
    public static void main(String[] args) {
        final Exchanger<Queue<ExchangedObject>> exchanger = new Exchanger<>();

        final ExchangedObjectFactory objectFactory = new ExchangedObjectFactory();
        final int producedObjectCount = 3;
        final ProducingTask producingTask = new ProducingTask(exchanger, objectFactory, producedObjectCount);

        final ConsumingTask consumingTask = new ConsumingTask(exchanger);

        new Thread(producingTask).start();
        new Thread(consumingTask).start();
    }
}
