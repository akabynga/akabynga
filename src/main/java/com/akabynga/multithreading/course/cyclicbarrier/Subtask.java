package com.akabynga.multithreading.course.cyclicbarrier;

import java.util.List;

public class Subtask extends CompositeTask<LeafTask> {

    public Subtask(final long id, final List<LeafTask> leafTasks) {
        super(id, leafTasks);
    }

    @Override
    protected void perform(final LeafTask leafTask) {
        leafTask.perform();
    }
}
