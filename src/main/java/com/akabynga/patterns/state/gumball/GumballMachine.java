package com.akabynga.patterns.state.gumball;

public class GumballMachine {

    private static final String NEW_LINE = "\n";
    private State state = State.SOLD_OUT;
    private int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            this.state = State.NO_QUARTER;
        }
    }

    public void insertQuarter() {
        switch (state) {
            case HAS_QUARTER -> System.out.println("You can't insert another quarter");
            case NO_QUARTER -> {
                System.out.println("You inserted a quarter");
                state = State.HAS_QUARTER;
            }
            case SOLD_OUT -> System.out.println("You can't insert a quarter, the machine is sold out");
            case SOLD -> System.out.println("Please wait, we're already giving you a gumball");
        }
    }

    public void ejectQuarter() {
        switch (state) {
            case HAS_QUARTER -> {
                System.out.println("Quarter returned");
                state = State.NO_QUARTER;
            }
            case NO_QUARTER -> System.out.println("You have not inserted a quarter");
            case SOLD -> System.out.println("Sorry, you already turned the crank");
            case SOLD_OUT -> System.out.println("You can't eject, you have not inserted a quarter yet");
        }
    }

    public void turnCrank() {
        switch (state) {
            case HAS_QUARTER -> {
                System.out.println("You turned...");
                state = State.SOLD;
                dispense();
            }
            case NO_QUARTER -> System.out.println("You turned but there's no quarter");
            case SOLD_OUT -> System.out.println("You turned, bt there are no gumballs");
            case SOLD -> System.out.println("Turning twice doesn't get you another gumball");
        }
    }

    public void dispense() {
        switch (state) {
            case HAS_QUARTER, SOLD_OUT -> System.out.println("No gumball dispensed");
            case NO_QUARTER -> System.out.println("You need to pay first");
            case SOLD -> {
                System.out.println("A gumball comes rolling out the slot");
                if (--count == 0) {
                    System.out.println("Oops, out of gumballs!");
                    state = State.SOLD_OUT;
                } else {
                    state = State.NO_QUARTER;
                }
            }
        }
    }


    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        state = State.NO_QUARTER;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(NEW_LINE).append("Mighty Gumball, Inc.");
        result.append(NEW_LINE).append("Java-enabled Standing Gumball Model #2004");
        result.append(NEW_LINE).append("Inventory: ").append(count).append(" gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append(NEW_LINE).append("Machine is ");
        if (state == State.SOLD_OUT) {
            result.append("sold out");
        } else if (state == State.NO_QUARTER) {
            result.append("waiting for quarter");
        } else if (state == State.HAS_QUARTER) {
            result.append("waiting for turn of crank");
        } else if (state == State.SOLD) {
            result.append("delivering a gumball");
        }
        result.append(NEW_LINE);
        return result.toString();
    }

    private enum State {
        SOLD_OUT, NO_QUARTER, HAS_QUARTER, SOLD
    }
}
