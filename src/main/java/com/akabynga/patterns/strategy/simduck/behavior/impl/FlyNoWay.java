package com.akabynga.patterns.strategy.simduck.behavior.impl;

import com.akabynga.patterns.strategy.simduck.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}
