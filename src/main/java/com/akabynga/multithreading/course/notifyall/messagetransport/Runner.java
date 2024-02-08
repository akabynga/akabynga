package com.akabynga.multithreading.course.notifyall.messagetransport;

import com.akabynga.multithreading.course.ThreadUtil;
import com.akabynga.multithreading.course.notifyall.messagetransport.broker.MessageBroker;
import com.akabynga.multithreading.course.notifyall.messagetransport.consumer.MessageConsumingTask;
import com.akabynga.multithreading.course.notifyall.messagetransport.producer.MessageFactory;
import com.akabynga.multithreading.course.notifyall.messagetransport.producer.MessageProducingTask;

public class Runner {

    public static void main(String[] args) {
        final int brokerMaxStoredMessages = 1;
        final MessageBroker messageBroker = new MessageBroker(brokerMaxStoredMessages);

        final MessageFactory messageFactory = new MessageFactory();

        final Thread firstProducingThread = new Thread(new MessageProducingTask(messageBroker, messageFactory));
        final Thread secondProducingThread = new Thread(new MessageProducingTask(messageBroker, messageFactory));

        final Thread firstConsumingThread = new Thread(new MessageConsumingTask(messageBroker));

        ThreadUtil.startThreads(firstProducingThread, secondProducingThread);
        ThreadUtil.startThreads(firstConsumingThread);
    }
}
