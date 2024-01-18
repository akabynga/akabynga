package com.akabynga.patterns.strategy.game.behavior.impl;

import com.akabynga.patterns.strategy.game.behavior.WeaponBehavior;

public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Sword slicing enemies!");
    }
}
