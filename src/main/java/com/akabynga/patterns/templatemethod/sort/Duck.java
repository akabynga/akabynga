package com.akabynga.patterns.templatemethod.sort;

public class Duck implements Comparable<Duck> {
    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return name + " weighs " + weight;
    }

    @Override
    public int compareTo(Duck object) {
        if (this.weight < object.weight) {
            return -1;
        } else if (this.weight == object.weight) {
            return 0;
        } else { // this.weight > otherDuck.weight
            return 1;
        }
    }
}