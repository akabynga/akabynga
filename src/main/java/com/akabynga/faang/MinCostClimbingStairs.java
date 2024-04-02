package com.akabynga.faang;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);

        return minCostClimbingStairs(cost, memo, cost.length);
    }

    private int minCostClimbingStairs(int[] cost, int[] memo, int step) {

        if (step < 0) {
            return 0;
        }
        if (step == 0 || step == 1) {
            return cost[step];
        }

        if (memo[step - 2] == -1) {
            memo[step - 2] = minCostClimbingStairs(cost, memo, step - 2);
        }
        if (memo[step - 1] == -1) {
            memo[step - 1] = minCostClimbingStairs(cost, memo, step - 1);
        }

        return (step == cost.length ? 0 : cost[step]) + Math.min(memo[step - 2], memo[step - 1]);
    }
}
