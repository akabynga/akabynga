package com.akabynga.patterns.strategy.game.behavior.impl;

import com.akabynga.patterns.strategy.game.behavior.WeaponBehavior;

public class AxeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("My axe cuts down enemies!");
    }
}
