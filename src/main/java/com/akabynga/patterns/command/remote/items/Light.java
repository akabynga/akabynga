package com.akabynga.patterns.command.remote.items;

public class Light {

    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println("Light is On: " + location);
    }

    public void off() {
        System.out.println("Light is Off: " + location);
    }
}
