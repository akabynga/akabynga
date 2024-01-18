package com.akabynga.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {3, 2, 3};
        System.out.println("Brut force: ");
        System.out.println(Arrays.toString(twoSum_BrutForce(array, 6)));
        System.out.println("---");

        System.out.println("HashMap solution: ");
        System.out.println(Arrays.toString(twoSum_HashMap(array, 6)));
        System.out.println("---");

    }

    public static int[] twoSum_BrutForce(int[] nums, int target) {

        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (unique.contains(nums[i])) {
                continue;
            }
            unique.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum_HashMap(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{i, map.get(difference)};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
