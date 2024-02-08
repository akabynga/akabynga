package com.akabynga.multithreading.course.exchanger;

import java.util.Queue;
import java.util.concurrent.Exchanger;

public class ConsumingTask extends ExchangingTask {

    public ConsumingTask(final Exchanger<Queue<ExchangedObject>> exchanger) {
        super(exchanger);
    }

    @Override
    protected void handle(final Queue<ExchangedObject> objects) {
        while (!objects.isEmpty()) {
            final ExchangedObject object = objects.poll();
            System.out.printf("%s was consumed\n", object);
        }
        System.out.println("------------------------------------------------");
    }
}
