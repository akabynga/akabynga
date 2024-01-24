package com.akabynga.patterns.factory.pizza.pizza.impl;

import com.akabynga.patterns.factory.pizza.pizza.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
//        this.name = "Chicago Style Deep Dish Cheese Pizza";
//        this.dough = "Extra Thick Crust Dough";
//        this.sauce = "Plum Tomato Sauce";
//        this.toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void prepare() {

    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
