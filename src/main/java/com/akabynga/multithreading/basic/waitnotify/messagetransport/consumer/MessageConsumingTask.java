package com.akabynga.multithreading.basic.waitnotify.messagetransport.consumer;

import com.akabynga.multithreading.basic.waitnotify.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.basic.waitnotify.messagetransport.model.Message;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public final class MessageConsumingTask implements Runnable {

    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_CONSUMING = 1;

    private final MessageBroker messageBroker;
    private final int minimalAmountMessagesToConsume;
    private final String name;

    public MessageConsumingTask(final MessageBroker messageBroker, final int minimalAmountMessagesToConsume, final String name) {
        this.messageBroker = messageBroker;
        this.minimalAmountMessagesToConsume = minimalAmountMessagesToConsume;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMinimalAmountMessagesToConsume() {
        return minimalAmountMessagesToConsume;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_CONSUMING);
                final Optional<Message> optionalConsumedMessage = this.messageBroker.consume(this);
                optionalConsumedMessage.orElseThrow(MessageConsumingException::new);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
