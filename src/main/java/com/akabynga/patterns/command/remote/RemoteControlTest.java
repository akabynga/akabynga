package com.akabynga.patterns.command.remote;

import com.akabynga.patterns.command.remote.impl.GarageDoorUpCommand;
import com.akabynga.patterns.command.remote.impl.LightOnCommand;
import com.akabynga.patterns.command.remote.items.GarageDoor;
import com.akabynga.patterns.command.remote.items.Light;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("Kitchen");
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed();

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorUpCommand garageDoorOpenCommand = new GarageDoorUpCommand(garageDoor);

        remote.setCommand(garageDoorOpenCommand);
        remote.buttonWasPressed();
    }
}
