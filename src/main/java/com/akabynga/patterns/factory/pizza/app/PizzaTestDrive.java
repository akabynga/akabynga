package com.akabynga.patterns.factory.pizza.app;

import com.akabynga.patterns.factory.pizza.PizzaStore;
import com.akabynga.patterns.factory.pizza.pizza.Pizza;
import com.akabynga.patterns.factory.pizza.store.ChicagoStylePizzaStore;
import com.akabynga.patterns.factory.pizza.store.NYStylePizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
