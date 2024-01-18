package com.akabynga.multithreading.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class FixedRateTimerDemo {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
            }
        };

        timer.scheduleAtFixedRate(task, 1000L, 1000L);

        Thread.sleep(1000L * 2);
    }
}
