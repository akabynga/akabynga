package com.akabynga.patterns.observer.weather.impl;

import com.akabynga.patterns.observer.weather.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private float heatIndex = 0.0f;


    public HeatIndexDisplay(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData wd) {

            float t = wd.getTemperature();
            float h = wd.getHumidity();
            heatIndex = (float)
                    (
                            (16.923 + (0.185212 * t)) +
                                    (5.37941 * h) -
                                    (0.100254 * t * h) +
                                    (0.00941695 * (t * t)) +
                                    (0.00728898 * (h * h)) +
                                    (0.000345372 * (t * t * h)) -
                                    (0.000814971 * (t * h * h)) +
                                    (0.0000102102 * (t * t * h * h)) -
                                    (0.000038646 * (t * t * t)) +
                                    (0.0000291583 * (h * h * h)) +
                                    (0.00000142721 * (t * t * t * h)) +
                                    (0.000000197483 * (t * h * h * h)) -
                                    (0.0000000218429 * (t * t * t * h * h)) +
                                    (0.000000000843296 * (t * t * h * h * h)) -
                                    (0.0000000000481975 * (t * t * t * h * h * h)));
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("Heat index is " + heatIndex);
    }
}