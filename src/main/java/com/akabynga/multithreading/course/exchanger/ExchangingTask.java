package com.akabynga.multithreading.course.exchanger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Exchanger;

public abstract class ExchangingTask implements Runnable {
    private final Exchanger<Queue<ExchangedObject>> exchanger;
    private Queue<ExchangedObject> objects;

    public ExchangingTask(final Exchanger<Queue<ExchangedObject>> exchanger) {
        this.exchanger = exchanger;
        this.objects = new ArrayDeque<>();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.handle(this.objects);
            this.exchange();
        }
    }

    protected abstract void handle(final Queue<ExchangedObject> objects);

    private void exchange() {
        try {
            objects = exchanger.exchange(objects);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
