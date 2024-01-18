package com.akabynga.patterns.observer.weather.impl;

import com.akabynga.patterns.observer.weather.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;


    public StatisticsDisplay(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData wd) {
            float t = wd.getTemperature();
            tempSum += t;
            numReadings++;

            if (t > maxTemp) {
                maxTemp = t;
            }

            if (t < minTemp) {
                minTemp = t;
            }
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }
}