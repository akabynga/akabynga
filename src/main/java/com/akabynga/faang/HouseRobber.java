package com.akabynga.faang;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        int current = 0;
        int next = 0;

        for (int num : nums) {
            int newCurrent = next + num;
            int newNext = Math.max(current, next);
            current = newCurrent;
            next = newNext;
        }

        return Math.max(current, next);
    }

    public int rob_memo(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Math.max(rob_memo(dp, nums, 0), rob_memo(dp, nums, 1));
    }

    public int rob_memo(int[] dp, int[] nums, int houseNumber) {

        if (houseNumber >= nums.length) {
            return 0;
        }
        if (dp[houseNumber] == -1) {
            dp[houseNumber] = nums[houseNumber] + Math.max(rob_memo(dp, nums, houseNumber + 2), rob_memo(dp, nums, houseNumber + 3));
        }

        return dp[houseNumber];
    }

    public int rob_recursive(int[] nums) {
        return Math.max(rob_recursive(nums, 0), rob_recursive(nums, 1));
    }

    public int rob_recursive(int[] nums, int houseNumber) {

        if (houseNumber >= nums.length) {
            return 0;
        }

        return nums[houseNumber] + Math.max(rob_recursive(nums, houseNumber + 2), rob_recursive(nums, houseNumber + 3));
    }
}
