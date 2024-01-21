package com.akabynga.patterns.factory.pizza.pizza;

import com.akabynga.patterns.factory.pizza.ingredient.*;

public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] veggies;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clam;

    public abstract void prepare();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void bake() {
        System.out.println("Baking for 25 minutes at 350 degrees...");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices...");
    }

    public void box() {
        System.out.println("Placing pizza in official PizzaStore box...");
    }

}