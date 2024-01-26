package com.akabynga.patterns.command.remote;

public class SimpleRemoteControl {

    private Command slot;

    public SimpleRemoteControl() {
        super();
    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
