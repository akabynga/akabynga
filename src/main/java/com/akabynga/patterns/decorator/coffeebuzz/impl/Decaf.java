package com.akabynga.patterns.decorator.coffeebuzz.impl;

import com.akabynga.patterns.decorator.coffeebuzz.Beverage;

public class Decaf extends Beverage {

    public Decaf() {
        this.description = "Without Caffeine";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
