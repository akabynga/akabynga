package com.akabynga.patterns.factory.pizza.pizza.impl;

import com.akabynga.patterns.factory.pizza.pizza.Pizza;

public class NYStyleVeggiePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing NY veggie pizza");
    }
}
