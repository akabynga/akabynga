package com.akabynga.patterns.state.gumballstate;

public class GumballMachine {

    private static final String NEW_LINE = "\n";
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;
    private State state;
    int count;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if (count > 0) {
            this.state = noQuarterState;
        } else {
            this.state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int count) {
        this.count = count;
        state = noQuarterState;
    }

    public State getState() {
        return state;
    }

    public void setState(StateType type) {
        switch (type) {
            case HAS_QUARTER -> state = hasQuarterState;
            case SOLD -> state = soldState;
            case NO_QUARTER -> state = noQuarterState;
            case SOLD_OUT -> state = soldOutState;
            case WINNER -> state = winnerState;
            default -> throw new IllegalStateException("State not recognized: " + type);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(NEW_LINE).append("Mighty Gumball, Inc.");
        result.append(NEW_LINE).append("Java-enabled Standing Gumball Model #2004");
        result.append(NEW_LINE).append("Inventory: ").append(count).append(" gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append(NEW_LINE);
        result.append("Machine is ").append(state).append(NEW_LINE);
        return result.toString();
    }
}
