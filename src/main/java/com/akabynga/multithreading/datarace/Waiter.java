package com.akabynga.multithreading.datarace;

class Waiter implements Runnable {
    private boolean shouldFinish;

    void finish() {
        shouldFinish = true;
    }

    public void run() {
        long iteration = 0;
        while (!shouldFinish) {
            iteration++;
        }
        System.out.println("Finished after: " + iteration);
    }
}
