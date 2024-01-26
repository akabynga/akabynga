package com.akabynga.patterns.command.remote.impl;

import com.akabynga.patterns.command.remote.Command;

public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("No command attached to the button");
    }

    @Override
    public void undo() {
        System.out.println("Nothing to undo");
    }
}
