package com.akabynga.patterns.factory.pizza.store;

import com.akabynga.patterns.factory.pizza.pizza.Pizza;
import com.akabynga.patterns.factory.pizza.PizzaStore;
import com.akabynga.patterns.factory.pizza.pizza.impl.CaliforniaStyleCheesePizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.CaliforniaStyleClamPizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.CaliforniaStylePepperoniPizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.CaliforniaStyleVeggiePizza;

public class CaliforniaStylePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CaliforniaStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new CaliforniaStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new CaliforniaStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new CaliforniaStyleVeggiePizza();
        }
        return pizza;
    }
}
