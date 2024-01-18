package com.akabynga.multithreading.datarace;

class DataRace {
    public static void main(String[] args) throws InterruptedException {
        Waiter waiter = new Waiter();
        Thread waiterThread = new Thread(waiter);
        waiterThread.start();
        waiter.finish();
        waiterThread.join();
    }
}