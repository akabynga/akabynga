package com.akabynga.patterns.strategy.simduck.impl;

import com.akabynga.patterns.strategy.simduck.Duck;
import com.akabynga.patterns.strategy.simduck.behavior.impl.FlyWithWings;
import com.akabynga.patterns.strategy.simduck.behavior.impl.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        super();
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
