package com.akabynga.multithreading.sync;

import com.akabynga.multithreading.utils.GuardedBy;

/**
 * Pattern "Monitor"
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    Object widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }
}
