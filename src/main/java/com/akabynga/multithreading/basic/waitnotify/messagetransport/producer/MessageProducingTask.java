package com.akabynga.multithreading.basic.waitnotify.messagetransport.producer;

import com.akabynga.multithreading.basic.waitnotify.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.basic.waitnotify.messagetransport.model.Message;

import java.util.concurrent.TimeUnit;

public final class MessageProducingTask implements Runnable {

    private static final String MESSAGE_OF_MESSAGE_IS_PRODUCED = "Message '%s' is produced.\n";
    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING = 3;
    private final MessageBroker messageBroker;
    private final MessageFactory messageFactory;


    public MessageProducingTask(final MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
        this.messageFactory = new MessageFactory();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                final Message producedMessage = this.messageFactory.create();
                TimeUnit.SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING);
                this.messageBroker.produce(producedMessage);
                System.out.printf(MESSAGE_OF_MESSAGE_IS_PRODUCED, producedMessage);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static final class MessageFactory {

        private static final int INITIAL_NEXT_MESSAGE_INDEX = 3;
        private static final String TEMPLATE_CREATED_MESSAGE_DATA = "Message#%d";
        private int nextMessageIndex;

        public MessageFactory() {
            this.nextMessageIndex = INITIAL_NEXT_MESSAGE_INDEX;
        }

        public Message create() {
            return new Message(String.format(TEMPLATE_CREATED_MESSAGE_DATA, this.nextMessageIndex++));
        }
    }
}
