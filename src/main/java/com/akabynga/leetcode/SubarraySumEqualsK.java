package com.akabynga.leetcode;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int target = 7;

        System.out.println(subarraySum(nums, target));
    }

    public static int subarraySum(int[] nums, int target) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - target, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
