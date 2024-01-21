package com.akabynga.patterns.factory.pizza.store;

import com.akabynga.patterns.factory.pizza.PizzaIngredientFactory;
import com.akabynga.patterns.factory.pizza.ingredient.factory.NYPizzaIngredientFactory;
import com.akabynga.patterns.factory.pizza.pizza.Pizza;
import com.akabynga.patterns.factory.pizza.PizzaStore;
import com.akabynga.patterns.factory.pizza.pizza.impl.*;

public class NYStylePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        }
        return pizza;
    }
}
