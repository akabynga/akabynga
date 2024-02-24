package com.akabynga.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate_Sort(nums));
    }

    public static boolean containsDuplicate_Streams(int[] nums) {
        return nums.length != Arrays.stream(nums).boxed().collect(Collectors.toSet()).size();
    }

    public static boolean containsDuplicate_Sort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> values = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (!values.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
