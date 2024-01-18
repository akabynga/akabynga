package com.akabynga.multithreading.philosophers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class State {

    private final int philosophersCount;
    private final Philosopher[] philosophers;

    private enum PhilosopherState {
        HUNGRY, EATING, THINKING
    }

    private final PhilosopherState[] state;

    private final Lock lock;
    private final Condition[] cond;

    public State(Philosopher[] philosophers) {
        this.philosophers = philosophers;
        this.philosophersCount = philosophers.length;
        lock = new ReentrantLock();
        state = new PhilosopherState[philosophersCount];
        cond = new Condition[philosophersCount];
        for (int i = 0; i < philosophersCount; i++) {
            state[i] = PhilosopherState.THINKING;
            cond[i] = lock.newCondition();
        }
    }

    public void takeForks(int id, Fork l, Fork r) {
        lock.lock();
        try {
            setState(id, PhilosopherState.HUNGRY);
            while (!philosophers[id].stopped.get() && (!l.getAvailability() || !r.getAvailability())) {
                cond[id].await();
            }
            l.setAvailability(false);
            r.setAvailability(false);
            setState(id, PhilosopherState.EATING);
            if (Runner.DEBUG) {
                printState(id);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void putForks(int id, Fork l, Fork r) {
        lock.lock();
        try {
            setState(id, PhilosopherState.THINKING);
            l.setAvailability(true);
            r.setAvailability(true);
            cond[(id + 1) % philosophersCount].signalAll();
            cond[(id + philosophersCount - 1) % philosophersCount].signalAll();
            if (Runner.DEBUG) {
                printState(id);
            }
        } finally {
            lock.unlock();
        }
    }

    private void setState(int id, PhilosopherState s) {
        state[id] = s;
    }

    private void printState(int id) {
        StringBuffer line = new StringBuffer();
        for (int i = 0; i < philosophersCount; i++) {
            switch (state[i]) {
                case THINKING -> line.append("O ");
                case HUNGRY -> line.append("- ");
                case EATING -> line.append("X ");
            }
        }
        System.out.println(line + "(" + (id + 1) + ")");
    }
}