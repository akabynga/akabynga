package com.akabynga.patterns.strategy.game.impl;

import com.akabynga.patterns.strategy.game.Character;
import com.akabynga.patterns.strategy.game.behavior.impl.AxeBehavior;

public class Troll extends Character {

    public Troll() {
        super();
        this.weaponBehavior = new AxeBehavior();
    }
}
