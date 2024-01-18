package com.akabynga.patterns.strategy.game.behavior.impl;

import com.akabynga.patterns.strategy.game.behavior.WeaponBehavior;

public class KnifeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("My knife reach to your heart!");
    }
}
