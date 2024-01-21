package com.akabynga.patterns.decorator.coffeebuzz;

public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;

    public abstract String getDescription();

    public Size getSize() {
        return beverage.getSize();
    }

}
