package com.akabynga.patterns.templatemethod.barista;

public class TeaWithHook extends CaffeineBeverageWithHook {

    public void brew() {
        System.out.println("Steeping the tea");
    }

    public void addCondiments() {
        System.out.println("Adding Lemon");
    }

    @Override
    protected String getUserInput() {
        // get the user's response
        System.out.print("Would you like lemon with your tea (y/n)? ");
        return askToAdd();
    }
}