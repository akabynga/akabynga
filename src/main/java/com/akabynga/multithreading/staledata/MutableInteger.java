package com.akabynga.multithreading.staledata;

import com.akabynga.multithreading.utils.NotThreadSafe;

@NotThreadSafe
public class MutableInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}