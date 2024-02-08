package com.akabynga.multithreading.course.waitnotify.messagetransport.producer;

import com.akabynga.multithreading.course.waitnotify.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.course.waitnotify.messagetransport.model.Message;

import java.util.concurrent.TimeUnit;

public final class MessageProducingTask implements Runnable {

    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING = 1;
    private final MessageBroker messageBroker;
    private final MessageFactory messageFactory;
    private final String name;

    private final int maximalAmountMessagesToProduce;

    public MessageProducingTask(final MessageBroker messageBroker, final MessageFactory messageFactory, final int maximalAmountMessagesToProduce, final String name) {
        this.messageBroker = messageBroker;
        this.messageFactory = messageFactory;
        this.maximalAmountMessagesToProduce = maximalAmountMessagesToProduce;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMaximalAmountMessagesToProduce() {
        return maximalAmountMessagesToProduce;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                final Message producedMessage = this.messageFactory.create();
                TimeUnit.SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING);
                this.messageBroker.produce(producedMessage, this);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
