package com.akabynga.faang;

import java.util.Arrays;

public class MinCostClimbingStairs {


    public int minCostClimbingStairs_bottomUp(int[] cost) {

        if (cost.length < 2) {
            return 0;
        }

        int twoStepBehind = cost[0];
        int oneStepBehind = cost[1];
        for (int i = 2; i < cost.length; i++) {
            twoStepBehind = oneStepBehind;
            oneStepBehind = oneStepBehind + cost[i];
        }

        return Math.min(twoStepBehind, oneStepBehind);
    }


    public int minCostClimbingStairs_bottomUpRecursive(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);

        return Math.min(minCostClimbingStairs_bottomUpRecursive(cost, memo, 0), minCostClimbingStairs_bottomUpRecursive(cost, memo, 1));
    }

    public int minCostClimbingStairs_bottomUpRecursive(int[] cost, int[] memo, int n) {

        if (n < 0 || n >= cost.length) {
            return 0;
        }

        if (memo[n] == -1) {
            memo[n] = cost[n] + Math.min(minCostClimbingStairs_bottomUpRecursive(cost, memo, n + 1), minCostClimbingStairs_bottomUpRecursive(cost, memo, n + 2));
        }

        return memo[n];
    }

    public int minCostClimbingStairs(int[] cost) {

        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);

        return Math.min(minCostClimbingStairs(cost, memo, cost.length - 1), minCostClimbingStairs(cost, memo, cost.length - 2));
    }

    public int minCostClimbingStairs(int[] cost, int[] memo, int step) {

        if (step < 0) {
            return 0;
        }
        if (step == 0 || step == 1) {
            return cost[step];
        }

        if (memo[step] == -1) {
            memo[step] = cost[step] + Math.min(minCostClimbingStairs(cost, memo, step - 1), minCostClimbingStairs(cost, memo, step - 2));
        }

        return memo[step];
    }

}
