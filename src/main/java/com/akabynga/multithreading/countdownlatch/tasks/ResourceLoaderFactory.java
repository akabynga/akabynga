package com.akabynga.multithreading.countdownlatch.tasks;

import java.util.concurrent.CountDownLatch;

public class ResourceLoaderFactory extends ResourceTaskFactory {

    private long nextSecondDuration = 1;

    @Override
    protected ResourceTask create(long id, CountDownLatch latch) {
        return new ResourceLoader(id, latch, this.nextSecondDuration++);
    }
}
