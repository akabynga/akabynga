package com.akabynga.patterns.decorator.coffeebuzz.impl;

import com.akabynga.patterns.decorator.coffeebuzz.Beverage;

public class Espresso extends Beverage {
    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
