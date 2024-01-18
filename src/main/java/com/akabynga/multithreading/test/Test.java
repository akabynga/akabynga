package com.akabynga.multithreading.test;

import java.util.List;

public class Test {
    public static final List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

    public static void main(String[] args) {
        list.set(1, 2);
    }
}
