package com.akabynga.multithreading.course.semaphore;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public abstract class AbstractPool<T> {

    private final List<PoolObject<T>> poolObjects;
    private final Semaphore semaphore;

    public AbstractPool(final Supplier<T> objectSupplier, final int size) {
        this.poolObjects = createPoolObjects(objectSupplier, size);
        this.semaphore = new Semaphore(size);
    }

    public final void release(T object) {
        if (releaseObject(object)) {
            semaphore.release();
        }
    }

    protected abstract void cleanObject(final T object);

    public final T acquired() {
        this.semaphore.acquireUninterruptibly();
        return this.acquiredObject();
    }

    private static <T> List<PoolObject<T>> createPoolObjects(final Supplier<T> objectsSupplier, final int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> objectsSupplier.get())
                .map(object -> new PoolObject<T>(object, false))
                .toList();
    }

    private synchronized T acquiredObject() {
        return poolObjects.stream()
                .filter(poolObject -> !poolObject.isIssued())
                .findFirst().map(AbstractPool::markAsIssued)
                .map(PoolObject::getObject)
                .orElseThrow(IllegalStateException::new);
    }

    private synchronized boolean releaseObject(final T object) {
        return poolObjects.stream()
                .filter(PoolObject::isIssued)
                .filter(poolObject -> Objects.equals(poolObject.getObject(), object))
                .findFirst()
                .map(this::cleanPoolObject).isPresent();
    }

    private PoolObject<T> cleanPoolObject(final PoolObject<T> poolObject) {
        poolObject.setIssued(false);
        this.cleanObject(poolObject.getObject());
        return poolObject;
    }

    private static <T> PoolObject<T> markAsIssued(final PoolObject<T> poolObject) {
        poolObject.setIssued(true);
        return poolObject;
    }

    private static final class PoolObject<T> {
        private final T object;
        private boolean issued;

        public PoolObject(final T object, final boolean issued) {
            this.object = object;
            this.issued = issued;
        }

        public boolean isIssued() {
            return issued;
        }

        public void setIssued(final boolean issued) {
            this.issued = issued;
        }

        public T getObject() {
            return object;
        }

    }
}
