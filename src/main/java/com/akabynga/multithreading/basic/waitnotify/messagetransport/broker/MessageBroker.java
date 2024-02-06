package com.akabynga.multithreading.basic.waitnotify.messagetransport.broker;

import com.akabynga.multithreading.basic.waitnotify.messagetransport.model.Message;

import java.util.ArrayDeque;
import java.util.Queue;

public final class MessageBroker {

    private final Queue<Message> messagesToBeConsumed;
    private final int maxStoreMessages;

    public MessageBroker(final int maxStoreMessages) {
        this.messagesToBeConsumed = new ArrayDeque<>(maxStoreMessages);
        this.maxStoreMessages = maxStoreMessages;
    }

    public synchronized void produce(final Message message) {
        try {
            while (this.messagesToBeConsumed.size() >= maxStoreMessages) {
                super.wait();
            }
            this.messagesToBeConsumed.add(message);
            super.notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized Message consume() {
        try {
            while (this.messagesToBeConsumed.isEmpty()) {
                super.wait();
            }
            Message consumedMessage = this.messagesToBeConsumed.poll();
            super.notify();
            return consumedMessage;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
