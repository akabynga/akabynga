package com.akabynga.multithreading.cyclicbarier.tasks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public final class LeafTask extends Task {

    private final long secondDuration;
    private final CyclicBarrier cyclicBarrier;

    public LeafTask(final long id, final long secondDuration, final CyclicBarrier cyclicBarrier) {
        super(id);
        this.secondDuration = secondDuration;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void perform() {
        try {
            System.out.printf("%s is starting\n", this);
            TimeUnit.SECONDS.sleep(this.secondDuration);
            System.out.printf("%s has finished\n", this);
            cyclicBarrier.await();
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (final BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
