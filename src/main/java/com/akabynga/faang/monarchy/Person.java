package com.akabynga.faang.monarchy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

    private final String name;

    private final List<Person> children;

    private boolean isAlive = true;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public Person(String name, List<Person> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
}
