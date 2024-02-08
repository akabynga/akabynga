package com.akabynga.multithreading.course.waitnotify.messagetransport;

import com.akabynga.multithreading.course.ThreadUtil;
import com.akabynga.multithreading.course.waitnotify.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.course.waitnotify.messagetransport.consumer.MessageConsumingTask;
import com.akabynga.multithreading.course.waitnotify.messagetransport.producer.MessageFactory;
import com.akabynga.multithreading.course.waitnotify.messagetransport.producer.MessageProducingTask;

public class Runner {

    public static void main(String[] args) {
        final int brokerMaxStoredMessages = 15;
        final MessageBroker messageBroker = new MessageBroker(brokerMaxStoredMessages);

        final MessageFactory messageFactory = new MessageFactory();

        final Thread firstProducingThread = new Thread(new MessageProducingTask(messageBroker, messageFactory, brokerMaxStoredMessages, "PRODUCER_1"));
        final Thread secondProducingThread = new Thread(new MessageProducingTask(messageBroker, messageFactory, 10, "PRODUCER_2"));
        final Thread thirdProducingThread = new Thread(new MessageProducingTask(messageBroker, messageFactory, 5, "PRODUCER_3"));

        final Thread firstConsumingThread = new Thread(new MessageConsumingTask(messageBroker, 0, "CONSUMER_1"));
        final Thread secondConsumingThread = new Thread(new MessageConsumingTask(messageBroker, 6, "CONSUMER_2"));
        final Thread thirdConsumingThread = new Thread(new MessageConsumingTask(messageBroker, 11, "CONSUMER_3"));

        ThreadUtil.startThreads(firstProducingThread, secondProducingThread, thirdProducingThread);
        ThreadUtil.startThreads(firstConsumingThread, secondConsumingThread, thirdConsumingThread);
    }
}
