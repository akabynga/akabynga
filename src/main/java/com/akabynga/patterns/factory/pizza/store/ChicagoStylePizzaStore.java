package com.akabynga.patterns.factory.pizza.store;

import com.akabynga.patterns.factory.pizza.pizza.Pizza;
import com.akabynga.patterns.factory.pizza.PizzaStore;
import com.akabynga.patterns.factory.pizza.pizza.impl.ChicagoStyleCheesePizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.ChicagoStyleClamPizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.ChicagoStylePepperoniPizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.ChicagoStyleVeggiePizza;

public class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
