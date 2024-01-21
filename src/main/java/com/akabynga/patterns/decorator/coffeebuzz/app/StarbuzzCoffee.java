package com.akabynga.patterns.decorator.coffeebuzz.app;

import com.akabynga.patterns.decorator.coffeebuzz.Beverage;
import com.akabynga.patterns.decorator.coffeebuzz.condiment.Mocha;
import com.akabynga.patterns.decorator.coffeebuzz.condiment.Soy;
import com.akabynga.patterns.decorator.coffeebuzz.condiment.Whip;
import com.akabynga.patterns.decorator.coffeebuzz.impl.DarkRoast;
import com.akabynga.patterns.decorator.coffeebuzz.impl.Espresso;
import com.akabynga.patterns.decorator.coffeebuzz.impl.HouseBlend;

public class StarbuzzCoffee {
    public static void main(String[] args) {

        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    }
}
