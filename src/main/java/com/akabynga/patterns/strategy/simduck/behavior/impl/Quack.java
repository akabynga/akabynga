package com.akabynga.patterns.strategy.simduck.behavior.impl;

import com.akabynga.patterns.strategy.simduck.behavior.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
