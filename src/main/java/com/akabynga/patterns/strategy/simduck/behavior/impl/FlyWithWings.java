package com.akabynga.patterns.strategy.simduck.behavior.impl;

import com.akabynga.patterns.strategy.simduck.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}

