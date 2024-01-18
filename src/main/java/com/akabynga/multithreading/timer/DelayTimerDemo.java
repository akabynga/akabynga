package com.akabynga.multithreading.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DelayTimerDemo {

    public static void main(String[] args) {
        System.out.println("Program started on: " + new Date() + "n" + "Thread's name: " + Thread.currentThread().getName());
        Timer timer = new Timer("Timer", false);

        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on: " + new Date() + "n" + "Thread's name: " + Thread.currentThread().getName());
                timer.cancel();
                timer.purge();
            }
        };

        long delay = 1000L;
        timer.schedule(task, delay);

    }
}
