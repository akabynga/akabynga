package com.akabynga.multithreading.course.notifyall.messagetransport.model;

import java.util.Objects;

public class Message {
    private final String data;

    public Message(final String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;

        return Objects.equals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[data = " + this.data + "]";
    }
}
