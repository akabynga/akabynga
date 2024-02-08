package com.akabynga.multithreading.course.phaser;

import java.util.concurrent.Phaser;

public final class LastLeafTask extends AbstractLeafTask {

    public LastLeafTask(final long id, final long secondDuration, final Phaser phaser) {
        super(id, secondDuration, phaser);
    }

    @Override
    protected void onFinish(Phaser phaser) {
        phaser.arriveAndDeregister();
    }
}
