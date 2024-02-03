package com.akabynga.multithreading.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        String initialReference = "the initially referenced string";
        AtomicReference<String> atomicStringReference = new AtomicReference<>(initialReference);

    }
}
