package com.akabynga.patterns.templatemethod.barista;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    protected String getUserInput() {
        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");
        return askToAdd();
    }
}