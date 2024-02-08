package com.akabynga.multithreading.course.notifyall.messagetransport.producer;

import com.akabynga.multithreading.course.notifyall.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.course.notifyall.messagetransport.model.Message;

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
