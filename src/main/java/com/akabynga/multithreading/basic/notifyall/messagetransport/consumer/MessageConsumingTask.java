package com.akabynga.multithreading.basic.notifyall.messagetransport.consumer;

import com.akabynga.multithreading.basic.notifyall.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.basic.notifyall.messagetransport.model.Message;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public final class MessageConsumingTask implements Runnable {

    private final MessageBroker messageBroker;

    public MessageConsumingTask(final MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            final Optional<Message> optionalConsumedMessage = this.messageBroker.consume();
            optionalConsumedMessage.orElseThrow(MessageConsumingException::new);
        }
    }

}
