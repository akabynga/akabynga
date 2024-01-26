package com.akabynga.patterns.command.remote;

import com.akabynga.patterns.command.remote.impl.*;
import com.akabynga.patterns.command.remote.items.HotTub;
import com.akabynga.patterns.command.remote.items.Light;
import com.akabynga.patterns.command.remote.items.Stereo;
import com.akabynga.patterns.command.remote.items.TV;

public class RemoteLoaderMacro {
    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Stereo stereo = new Stereo("Living Room");
        TV tv = new TV("Living Room");
        HotTub hotTub = new HotTub();

        LightOffCommand lightOffCommand = new LightOffCommand(livingRoomLight);
        LightOnCommand lightOnCommand = new LightOnCommand(livingRoomLight);

        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);

        HotTubOnCommand hotTubOnCommand = new HotTubOnCommand(hotTub);
        HotTubOffCommand hotTubOffCommand = new HotTubOffCommand(hotTub);

        Command[] partyOnCommands = {lightOnCommand, stereoOffCommand, tvOnCommand, hotTubOnCommand};
        Command[] partyOffCommands = {lightOffCommand, stereoOffCommand, tvOffCommand, hotTubOffCommand};

        MacroCommand macroOnCommand = new MacroCommand(partyOnCommands);
        MacroCommand macroOffCommand = new MacroCommand(partyOffCommands);

        remoteControl.setCommand(0, macroOnCommand, macroOffCommand);

        System.out.println(remoteControl);
        System.out.println("--- Pushing Macro On ---");
        remoteControl.onButtonWasPushed(0);
        System.out.println("--- Pushing Macro Off ---");
        remoteControl.offButtonWasPushed(0);

    }
}
