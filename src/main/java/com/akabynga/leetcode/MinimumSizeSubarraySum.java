package com.akabynga.leetcode;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {

        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int length = 0;
        int sum = 0;

        for (int i = 0, currentIndex = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum>=7){

            }

        }

        return length;
    }
}
