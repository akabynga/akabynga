package com.akabynga.patterns.decorator.coffeebuzz.impl;

import com.akabynga.patterns.decorator.coffeebuzz.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        this.description = "Dark Roast";
    }

    @Override
    public double cost() {
        return .99;
    }
}
