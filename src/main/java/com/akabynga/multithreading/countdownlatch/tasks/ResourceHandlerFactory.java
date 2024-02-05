package com.akabynga.multithreading.countdownlatch.tasks;

import java.util.concurrent.CountDownLatch;

public class ResourceHandlerFactory extends ResourceTaskFactory {

    @Override
    protected ResourceTask create(long id, final CountDownLatch latch) {
        return new ResourceHandler(id, latch);
    }

}
