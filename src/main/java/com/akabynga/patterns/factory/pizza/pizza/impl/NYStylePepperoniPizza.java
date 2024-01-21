package com.akabynga.patterns.factory.pizza.pizza.impl;

import com.akabynga.patterns.factory.pizza.pizza.Pizza;

public class NYStylePepperoniPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing NY pepperoni pizza");
    }
}
