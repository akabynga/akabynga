package com.akabynga.multithreading.vehicle;

import com.akabynga.multithreading.utils.NotThreadSafe;

@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }

    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + ']';
    }
}