package com.akabynga.leetcode;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {

        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = n + 1;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (result != n + 1) ? result : 0;
    }
}
