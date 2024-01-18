package com.akabynga.multithreading.vehicle.delegating;

import com.akabynga.multithreading.utils.Immutable;

@Immutable
public final class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}