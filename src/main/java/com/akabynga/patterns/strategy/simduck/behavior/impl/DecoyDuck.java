package com.akabynga.patterns.strategy.simduck.behavior.impl;

import com.akabynga.patterns.strategy.simduck.behavior.QuackBehavior;

public class DecoyDuck implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Come here my little duck xD");
    }
}
