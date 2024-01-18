package com.akabynga.patterns.strategy.simduck.impl;

import com.akabynga.patterns.strategy.simduck.Duck;
import com.akabynga.patterns.strategy.simduck.behavior.impl.FlyNoWay;
import com.akabynga.patterns.strategy.simduck.behavior.impl.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck!");
    }
}
