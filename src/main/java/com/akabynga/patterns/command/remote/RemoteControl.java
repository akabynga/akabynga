package com.akabynga.patterns.command.remote;

import com.akabynga.patterns.command.remote.impl.NoCommand;

public class RemoteControl {

    private final Command[] onCommands;
    private final Command[] offCommands;

    private Command undoCommand;

    public RemoteControl() {
        this.onCommands = new Command[7];
        this.offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot ").append(i).append("] ").append(onCommands[i].getClass().getName()).append("                ")
                    .append(offCommands[i].getClass().getName()).append("\n");
        }
        if (undoCommand != null) {
            sb.append("[undo]").append(undoCommand.getClass().getName()).append("\n");
        }
        return sb.toString();
    }
}
