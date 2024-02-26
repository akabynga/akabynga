package com.akabynga.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        int number = 4;

        System.out.println(climbStairs(number));
    }

    public static int climbStairs(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int twoStepBehind = 1; // for 1
        int oneStepBehind = 2; // for 2

        for (int i = 3; i <= n; i++) {
            int answer = twoStepBehind + oneStepBehind;
            twoStepBehind = oneStepBehind;
            oneStepBehind = answer;
        }

        return oneStepBehind;
    }
}
