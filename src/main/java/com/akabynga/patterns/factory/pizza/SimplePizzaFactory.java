package com.akabynga.patterns.factory.pizza;

import com.akabynga.patterns.factory.pizza.pizza.*;
import com.akabynga.patterns.factory.pizza.pizza.impl.CheesePizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.ClamPizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.PepperoniPizza;
import com.akabynga.patterns.factory.pizza.pizza.impl.VeggiePizza;

public class SimplePizzaFactory {

    public Pizza creatPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
