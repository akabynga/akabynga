package com.akabynga.multithreading.vehicle;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VehicleDemo {
    public static void main(String[] args) {

        Map<String, MutablePoint> vehicles = new HashMap<>();

        vehicles.put("Audi", new MutablePoint());
        vehicles.put("BMW", new MutablePoint());
        vehicles.put("Porsche", new MutablePoint());
        vehicles.put("Mercedes", new MutablePoint());
        vehicles.put("Lamborghini", new MutablePoint());
        vehicles.put("Tesla", new MutablePoint());

        MonitorVehicleTracker tracker = new MonitorVehicleTracker(vehicles);

        Random r = new Random();
        for (String name : vehicles.keySet()) {
            startProcess(name, tracker);
        }
        for (; ; ) {
            for (String name : vehicles.keySet()) {
                System.out.println(name + ": " + tracker.getLocation(name));
            }
        }

    }

    private static void startProcess(String name, MonitorVehicleTracker tracker) {
        new Thread(() -> {
            Random random = new Random();
            int xSign = random.nextInt() % 2 == 0 ? 1 : -1;
            int ySign = random.nextInt() % 2 == 0 ? 1 : -1;

            for (; ; ) {
                tracker.setLocation(name, tracker.getLocation(name).x + xSign * random.nextInt(10), tracker.getLocation(name).y + ySign * random.nextInt(10));
            }
        }, name).start();
    }
}
