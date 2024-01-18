package com.akabynga.patterns.strategy.simduck.app;

import com.akabynga.patterns.strategy.simduck.Duck;
import com.akabynga.patterns.strategy.simduck.behavior.impl.FlyRocketPowered;
import com.akabynga.patterns.strategy.simduck.impl.MallardDuck;
import com.akabynga.patterns.strategy.simduck.impl.ModelDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        System.out.println("--------------");

        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();
        System.out.println("{ changing behavior }");
        model.setFlyBehavior(new FlyRocketPowered());

        model.performFly();

    }
}
