package com.akabynga.patterns.command.remote.impl;

import com.akabynga.patterns.command.remote.Command;
import com.akabynga.patterns.command.remote.items.HotTub;

public class HotTubOnCommand implements Command {

    private HotTub hotTub;

    public HotTubOnCommand(HotTub hotTub) {
        this.hotTub = hotTub;
    }

    @Override
    public void execute() {
        hotTub.on();
        hotTub.bubblesOn();
        hotTub.jetsOn();
        hotTub.heat();
    }

    @Override
    public void undo() {
        hotTub.bubblesOff();
        hotTub.jetsOff();
        hotTub.off();
    }
}
