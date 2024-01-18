package com.akabynga.multithreading.escaped;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(EventListener e) {
                doSomething(e);
            }
        };
    }

    private void doSomething(EventListener e) {
        // DO SOMETHING
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    static class EventSource {
        List<EventListener> listeners = new ArrayList<>();

        void registerListener(EventListener e) {
            listeners.add(e);
        }
    }
}