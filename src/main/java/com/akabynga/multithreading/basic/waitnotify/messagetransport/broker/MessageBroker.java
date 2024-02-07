package com.akabynga.multithreading.basic.waitnotify.messagetransport.broker;

import com.akabynga.multithreading.basic.waitnotify.messagetransport.consumer.MessageConsumingTask;
import com.akabynga.multithreading.basic.waitnotify.messagetransport.model.Message;
import com.akabynga.multithreading.basic.waitnotify.messagetransport.producer.MessageProducingTask;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public final class MessageBroker {

    private static final String MESSAGE_OF_MESSAGE_IS_PRODUCED = "Message '%s' is produced by producer with name '%s'. Amount of messages before producing: %d.\n";
    private static final String MESSAGE_OF_MESSAGE_IS_CONSUMED = "Message '%s' is consumed by consumed with name '%s'. Amount of messages before consuming: %d.\n";

    private final Queue<Message> messagesToBeConsumed;
    private final int maxStoreMessages;

    public MessageBroker(final int maxStoreMessages) {
        this.messagesToBeConsumed = new ArrayDeque<>(maxStoreMessages);
        this.maxStoreMessages = maxStoreMessages;
    }

    public synchronized void produce(final Message message, final MessageProducingTask messageProducingTask) {
        try {
            while (!isShouldProduce(messageProducingTask)) {
                super.wait();
            }
            this.messagesToBeConsumed.add(message);
            System.out.printf(MESSAGE_OF_MESSAGE_IS_PRODUCED, message, messageProducingTask.getName(),
                    this.messagesToBeConsumed.size() - 1);
            super.notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized Optional<Message> consume(final MessageConsumingTask messageConsumingTask) {
        try {
            while (!isShouldConsume(messageConsumingTask)) {
                super.wait();
            }
            Message consumedMessage = this.messagesToBeConsumed.poll();
            System.out.printf(MESSAGE_OF_MESSAGE_IS_CONSUMED, consumedMessage, messageConsumingTask.getName(),
                    this.messagesToBeConsumed.size() + 1);
            super.notify();
            return Optional.ofNullable(consumedMessage);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }

    private boolean isShouldProduce(final MessageProducingTask messageProducingTask) {
        return this.messagesToBeConsumed.size() < this.maxStoreMessages
                && this.messagesToBeConsumed.size() <= messageProducingTask.getMaximalAmountMessagesToProduce();
    }

    private boolean isShouldConsume(final MessageConsumingTask messageConsumingTask) {
        return !this.messagesToBeConsumed.isEmpty()
                && this.messagesToBeConsumed.size() >= messageConsumingTask.getMinimalAmountMessagesToConsume();
    }
}
