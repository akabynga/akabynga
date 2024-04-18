package com.akabynga.patterns.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator<T extends MenuComponent> implements Iterator<MenuComponent> {

    private final Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    public MenuComponent next() {
        if (hasNext()) {
            Iterator<? extends MenuComponent> iterator = stack.peek();
            MenuComponent component = iterator.next();
            stack.push(component.iterator());
            return component;
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            Iterator<MenuComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
