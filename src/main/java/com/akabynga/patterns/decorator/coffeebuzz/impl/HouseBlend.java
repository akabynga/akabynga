package com.akabynga.patterns.decorator.coffeebuzz.impl;

import com.akabynga.patterns.decorator.coffeebuzz.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
