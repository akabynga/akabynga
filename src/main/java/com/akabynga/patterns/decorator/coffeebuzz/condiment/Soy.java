package com.akabynga.patterns.decorator.coffeebuzz.condiment;

import com.akabynga.patterns.decorator.coffeebuzz.Beverage;
import com.akabynga.patterns.decorator.coffeebuzz.CondimentDecorator;

public class Soy extends CondimentDecorator {
    private final Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double beverageCost = beverage.cost();
        if (getSize() == Size.TALL) {
            return .10 * beverageCost;
        } else if (getSize() == Size.GRANDE) {
            return .15 * beverageCost;
        } else if (getSize() == Size.VENTI) {
            return .20 * beverageCost;
        }
        return beverageCost;
    }

}
