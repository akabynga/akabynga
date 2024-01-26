package com.akabynga.patterns.command.remote.impl;

import com.akabynga.patterns.command.remote.Command;
import com.akabynga.patterns.command.remote.items.Light;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
