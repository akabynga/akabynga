package com.akabynga.multithreading.course.notifyall.messagetransport.producer;

import com.akabynga.multithreading.course.notifyall.messagetransport.model.Message;

public final class MessageFactory {

    private static final int INITIAL_NEXT_MESSAGE_INDEX = 3;
    private static final String TEMPLATE_CREATED_MESSAGE_DATA = "Message#%d";
    private int nextMessageIndex;

    public MessageFactory() {
        this.nextMessageIndex = INITIAL_NEXT_MESSAGE_INDEX;
    }

    public Message create() {
        return new Message(String.format(TEMPLATE_CREATED_MESSAGE_DATA, this.findAndIncrementNextMessageIndex()));
    }

    private synchronized int findAndIncrementNextMessageIndex() {
        return this.nextMessageIndex++;
    }
}