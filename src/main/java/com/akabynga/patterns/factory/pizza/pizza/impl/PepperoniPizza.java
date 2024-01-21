package com.akabynga.patterns.factory.pizza.pizza.impl;

import com.akabynga.patterns.factory.pizza.PizzaIngredientFactory;
import com.akabynga.patterns.factory.pizza.pizza.Pizza;

public class PepperoniPizza extends Pizza {

    protected PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        this.dough = ingredientFactory.createDough();
        this.cheese = ingredientFactory.createCheese();
        this.sauce = ingredientFactory.createSauce();
        this.pepperoni = ingredientFactory.createPepperoni();
    }

}