package com.akabynga.patterns.strategy.game.behavior.impl;

import com.akabynga.patterns.strategy.game.behavior.WeaponBehavior;

public class BowAndArrowBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("I shoot you right in the eye!");
    }
}
