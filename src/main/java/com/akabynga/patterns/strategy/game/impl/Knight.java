package com.akabynga.patterns.strategy.game.impl;

import com.akabynga.patterns.strategy.game.Character;
import com.akabynga.patterns.strategy.game.behavior.impl.SwordBehavior;

public class Knight extends Character {

    public Knight() {
        this.weaponBehavior = new SwordBehavior();
    }
}
