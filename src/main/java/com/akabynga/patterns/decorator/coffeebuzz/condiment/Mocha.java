package com.akabynga.patterns.decorator.coffeebuzz.condiment;

import com.akabynga.patterns.decorator.coffeebuzz.Beverage;
import com.akabynga.patterns.decorator.coffeebuzz.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    private final Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        double beverageCost = beverage.cost();
        if (getSize() == Size.TALL) {
            return .15 * beverageCost;
        } else if (getSize() == Size.GRANDE) {
            return .20 * beverageCost;
        } else if (getSize() == Size.VENTI) {
            return .25 * beverageCost;
        }
        return beverageCost;
    }
}
