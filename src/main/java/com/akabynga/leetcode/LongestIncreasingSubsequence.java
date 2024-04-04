package com.akabynga.leetcode;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int number : dp) {
            max = Math.max(max, number);
        }
        return max;
    }

}
