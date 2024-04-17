package com.akabynga.patterns.iterator;

import java.util.Iterator;

public class DinerMenu implements Menu {

    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private final MenuItem[] menuItems;


    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hot dog",
                "A hot dog, with sauerkraut, relish, onions, topped with cheese",
                false, 3.05);
        addItem("Steamed Veggies and Brown Rice",
                "Steamed vegetables over brown rice", true, 3.99);
        addItem("Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true, 3.89);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu.");
        } else {
            menuItems[numberOfItems++] = item;
        }
    }

    public int size() {
        return numberOfItems;
    }

    @Override
    public String getMenuDescription() {
        return "LUNCH";
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new DinerMenuIterator();
    }

    private class DinerMenuIterator implements Iterator<MenuItem> {

        private int index = 0;


        public DinerMenuIterator() {

        }

        @Override
        public boolean hasNext() {
            return index >= 0 && index < menuItems.length && menuItems[index] != null;
        }

        @Override
        public MenuItem next() {
            return menuItems[index++];
        }

        @Override
        public void remove() {

            if (numberOfItems <= 0) {
                throw new IllegalStateException("You can't remove an item until you've done at least one next()");
            }
            if (menuItems[numberOfItems - 1] != null) {
                for (int i = numberOfItems - 1; i < (menuItems.length - 1); i++) {
                    menuItems[i] = menuItems[i + 1];
                }
                menuItems[menuItems.length - 1] = null;
                numberOfItems--;
            }
        }
    }
}
