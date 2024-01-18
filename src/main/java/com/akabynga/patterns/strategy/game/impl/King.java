package com.akabynga.patterns.strategy.game.impl;

import com.akabynga.patterns.strategy.game.Character;
import com.akabynga.patterns.strategy.game.behavior.impl.KnifeBehavior;

public class King extends Character {

    public King() {
        this.weaponBehavior = new KnifeBehavior();
    }
}
