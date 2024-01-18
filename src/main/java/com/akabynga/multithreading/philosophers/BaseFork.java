package com.akabynga.multithreading.philosophers;

import java.time.LocalDateTime;

public class BaseFork {

    private final int id;

    public BaseFork(int id) {
        this.id = id;
    }

    public void take() {
        if (Runner1.DEBUG) {
            System.out.println(Runner1.TIME_FORMATTER.format(LocalDateTime.now()) + ": Fork " + id + " is taken");
        }
    }

    public void put() {
        if (Runner1.DEBUG) {
            System.out.println(Runner1.TIME_FORMATTER.format(LocalDateTime.now()) + ": Fork " + id + " is put");
        }
    }
}
