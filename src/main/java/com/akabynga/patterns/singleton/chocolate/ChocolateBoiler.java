package com.akabynga.patterns.singleton.chocolate;

public class ChocolateBoiler {

    private volatile static ChocolateBoiler instance;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
        this.empty = true;
        this.boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            synchronized (ChocolateBoiler.class) {
                if (instance == null) {
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            this.empty = false;
            this.boiled = false;
            // заполненние нагревателя молочно-шоколадной смесью
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            //слить нагретое молоко
            this.empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // Довести содержимое до кипения
            this.boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
