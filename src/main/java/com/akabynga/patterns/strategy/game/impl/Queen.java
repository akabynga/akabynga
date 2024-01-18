package com.akabynga.patterns.strategy.game.impl;

import com.akabynga.patterns.strategy.game.Character;
import com.akabynga.patterns.strategy.game.behavior.impl.BowAndArrowBehavior;

public class Queen extends Character {

    public Queen() {
        super();
        this.weaponBehavior = new BowAndArrowBehavior();
    }
}
