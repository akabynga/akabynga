package com.akabynga.patterns.composite;

import java.util.Iterator;

public class Waitress {

    private final MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void addMenu(MenuComponent menu) {
        allMenus.add(menu);
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarian() {
        Iterator<MenuComponent> iterator = allMenus.iterator();
        System.out.println("\nVEGETARIAN MENU");
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("----------------------");
                System.out.println(menuComponent.getName());
                System.out.println("----------------------");
            }
        }
    }
}
