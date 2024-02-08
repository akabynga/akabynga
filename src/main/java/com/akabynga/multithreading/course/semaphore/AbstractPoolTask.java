package com.akabynga.multithreading.course.semaphore;

public abstract class AbstractPoolTask<T> implements Runnable {

    private final AbstractPool<T> pool;

    public AbstractPoolTask(final AbstractPool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        final T object = pool.acquired();
        try {
            System.out.printf("%s was acquired.\n", object);
            handle(object);
        } finally {
            System.out.printf("%s was released.\n", object);
            pool.release(object);
        }
    }

    protected abstract void handle(final T object);
}
