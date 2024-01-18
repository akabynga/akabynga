package com.akabynga.patterns.strategy.game.app;

import com.akabynga.patterns.strategy.game.Character;
import com.akabynga.patterns.strategy.game.behavior.impl.AxeBehavior;
import com.akabynga.patterns.strategy.game.impl.Queen;

public class GameRunner {
    public static void main(String[] args) {

        Character c = new Queen();
        c.fight();
        c.setWeaponBehavior(new AxeBehavior());
        c.fight();
    }
}
