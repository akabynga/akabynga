package com.akabynga.patterns.factory.pizza.pizza.impl;

import com.akabynga.patterns.factory.pizza.pizza.Pizza;

public class ChicagoStyleVeggiePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing chicago veggie pizza");
    }
}
