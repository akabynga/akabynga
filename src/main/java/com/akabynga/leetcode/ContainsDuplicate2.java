package com.akabynga.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length < 2 || k == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (right < k) {
                if (!set.add(nums[right])) {
                    return true;
                }
            } else {
                if (!set.add(nums[right])) {
                    return true;
                }
                if (set.size() >= k + 1) {
                    set.remove(nums[left++]);
                }

            }

        }
        return false;
    }
}
