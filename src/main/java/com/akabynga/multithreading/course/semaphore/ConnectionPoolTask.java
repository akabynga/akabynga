package com.akabynga.multithreading.course.semaphore;

import java.util.concurrent.TimeUnit;

public final class ConnectionPoolTask extends AbstractPoolTask<Connection> {


    public ConnectionPoolTask(AbstractPool<Connection> pool) {
        super(pool);
    }

    @Override
    protected void handle(final Connection connection) {
        try {
            connection.setAutoCommit(false);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
