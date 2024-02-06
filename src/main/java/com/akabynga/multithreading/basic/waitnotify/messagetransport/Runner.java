package com.akabynga.multithreading.basic.waitnotify.messagetransport;

import com.akabynga.multithreading.basic.waitnotify.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.basic.waitnotify.messagetransport.consumer.MessageConsumingTask;
import com.akabynga.multithreading.basic.waitnotify.messagetransport.producer.MessageProducingTask;

public class Runner {

    public static void main(String[] args) {
        final int brokerMaxStoredMessages = 5;
        final MessageBroker messageBroker = new MessageBroker(brokerMaxStoredMessages);

        final Thread producingThread = new Thread(new MessageProducingTask(messageBroker));
        final Thread consumingThread = new Thread(new MessageConsumingTask(messageBroker));

        producingThread.start();
        consumingThread.start();
    }
}
