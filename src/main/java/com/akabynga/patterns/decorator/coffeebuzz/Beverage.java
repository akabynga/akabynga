package com.akabynga.patterns.decorator.coffeebuzz;

public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public enum Size {TALL, GRANDE, VENTI}

    protected Size size = Size.TALL;

    public String getDescription() {
        if (size == Size.TALL) {
            description = "Tall " + description;
        } else if (size == Size.GRANDE) {
            description = "Grande " + description;
        } else if (size == Size.VENTI) {
            description = "Venti " + description;
        }
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public abstract double cost();
}
