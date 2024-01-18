package com.akabynga.patterns.strategy.game;

import com.akabynga.patterns.strategy.game.behavior.WeaponBehavior;

public abstract class Character {

    protected WeaponBehavior weaponBehavior;

    public void fight() {
        weaponBehavior.useWeapon();
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
