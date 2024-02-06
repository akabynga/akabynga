package com.akabynga.multithreading.basic.waitnotify.messagetransport.consumer;

import com.akabynga.multithreading.basic.waitnotify.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.basic.waitnotify.messagetransport.model.Message;

import java.util.concurrent.TimeUnit;

public final class MessageConsumingTask implements Runnable {

    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_CONSUMING = 1;
    private static final String TEMPLATE_MESSAGE_OF_MESSAGE_IS_CONSUMED = "Message '%s' is consumed.\n";

    private final MessageBroker messageBroker;


    public MessageConsumingTask(final MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_CONSUMING);
                final Message consumedMessage = this.messageBroker.consume();
                System.out.printf(TEMPLATE_MESSAGE_OF_MESSAGE_IS_CONSUMED, consumedMessage);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
