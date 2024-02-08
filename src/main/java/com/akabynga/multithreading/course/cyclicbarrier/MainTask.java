package com.akabynga.multithreading.course.cyclicbarrier;

import java.util.List;

public class MainTask extends CompositeTask<Subtask> {

    public MainTask(final long id, final List<Subtask> subtasks) {
        super(id, subtasks);
    }

    @Override
    protected void perform(final Subtask subtask) {
        new Thread(subtask::perform).start();
    }
}
