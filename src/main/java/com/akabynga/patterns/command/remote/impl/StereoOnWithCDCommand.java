package com.akabynga.patterns.command.remote.impl;

import com.akabynga.patterns.command.remote.Command;
import com.akabynga.patterns.command.remote.items.Stereo;

public class StereoOnWithCDCommand implements Command {
    private final Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }


    @Override
    public void undo() {
        stereo.off();
    }
}
