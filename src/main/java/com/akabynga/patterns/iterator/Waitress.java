package com.akabynga.patterns.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Waitress {

    private final List<Menu> menus;

    public Waitress(Menu... menuArray) {
        this.menus = new ArrayList<>();
        menus.addAll(Arrays.asList(menuArray));
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void printMenu() {

        System.out.println("MENU");
        System.out.println("----");
        for (Menu menu : menus) {
            System.out.println(menu.getMenuDescription());
            printMenu(menu.iterator());
        }
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.name() + ", ");
            System.out.print(menuItem.price() + " -- ");
            System.out.println(menuItem.description());
        }
    }

    public void printVegetarianMenu() {
        for (Menu menu : menus) {
            printVegetarianMenu(menu.iterator());
        }
    }

    public boolean isItemVegetarian(String name) {
        for (Menu menu : menus) {
            if (isVegetarian(name, menu.iterator())) {
                return true;
            }
        }
        return false;
    }


    private void printVegetarianMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            if (menuItem.vegetarian()) {
                System.out.print(menuItem.name());
                System.out.println("\t\t" + menuItem.price());
                System.out.println("\t" + menuItem.description());
            }
        }
    }

    private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            if (menuItem.name().equals(name) && menuItem.vegetarian()) {
                return true;
            }
        }
        return false;
    }
}
