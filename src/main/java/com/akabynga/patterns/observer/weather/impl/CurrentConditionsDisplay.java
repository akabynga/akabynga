package com.akabynga.patterns.observer.weather.impl;

import com.akabynga.patterns.observer.weather.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData wd) {
            this.temperature = wd.getTemperature();
            this.humidity = wd.getHumidity();
        }
        display();
    }
}
