package com.akabynga.patterns.iterator;

public interface Menu extends Iterable<MenuItem> {

    String getMenuDescription();

    int size();
}
