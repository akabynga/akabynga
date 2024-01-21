package com.akabynga.patterns.factory.pizza.pizza.impl;

import com.akabynga.patterns.factory.pizza.pizza.Pizza;

public class ChicagoStyleClamPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing chicago clam pizza");
    }
}
