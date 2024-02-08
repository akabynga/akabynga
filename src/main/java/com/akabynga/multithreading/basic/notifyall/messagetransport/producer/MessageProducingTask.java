package com.akabynga.multithreading.basic.notifyall.messagetransport.producer;

import com.akabynga.multithreading.basic.notifyall.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.basic.notifyall.messagetransport.model.Message;

import java.util.concurrent.TimeUnit;

public final class MessageProducingTask implements Runnable {

    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING = 1;
    private final MessageBroker messageBroker;
    private final MessageFactory messageFactory;

    public MessageProducingTask(final MessageBroker messageBroker, final MessageFactory messageFactory) {
        this.messageBroker = messageBroker;
        this.messageFactory = messageFactory;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            final Message producedMessage = this.messageFactory.create();
            this.messageBroker.produce(producedMessage);
        }
    }

}
