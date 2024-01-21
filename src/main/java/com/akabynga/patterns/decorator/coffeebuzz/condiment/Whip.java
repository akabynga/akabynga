package com.akabynga.patterns.decorator.coffeebuzz.condiment;

import com.akabynga.patterns.decorator.coffeebuzz.Beverage;
import com.akabynga.patterns.decorator.coffeebuzz.CondimentDecorator;

public class Whip extends CondimentDecorator {
    private final Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
