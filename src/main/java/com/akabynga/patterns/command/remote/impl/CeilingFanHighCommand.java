package com.akabynga.patterns.command.remote.impl;

import com.akabynga.patterns.command.remote.Command;
import com.akabynga.patterns.command.remote.items.CeilingFan;

public class CeilingFanHighCommand extends CeilingFanCommand {

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

}
