package com.akabynga.patterns.command.remote.impl;

import com.akabynga.patterns.command.remote.Command;
import com.akabynga.patterns.command.remote.items.HotTub;

public class HotTubOffCommand implements Command {

    private HotTub hotTub;

    public HotTubOffCommand(HotTub hotTub) {
        this.hotTub = hotTub;
    }

    @Override
    public void execute() {
        hotTub.bubblesOff();
        hotTub.jetsOff();
        hotTub.off();
    }

    @Override
    public void undo() {
        hotTub.on();
        hotTub.bubblesOn();
        hotTub.jetsOn();
        hotTub.heat();
    }
}
