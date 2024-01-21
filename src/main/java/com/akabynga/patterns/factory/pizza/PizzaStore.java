package com.akabynga.patterns.factory.pizza;

import com.akabynga.patterns.factory.pizza.pizza.Pizza;

public abstract class PizzaStore {

    public PizzaStore() {
        super();
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);

}
