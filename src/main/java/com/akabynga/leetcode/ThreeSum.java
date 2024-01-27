package com.akabynga.leetcode;

import com.akabynga.cursera.algorithms.week1.Percolation;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        // Output: [[-1,-1,2],[-1,0,1]]
        int[] array = {-1, 0, 1, 2, -1, -4};
//        int[] array = {-2, 0, 1, 1, 2};
//        int[] array = {0, 0, 0, 0};
        System.out.println(threeSum(array));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }

    public static List<List<Integer>> threeSum_slow(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> temp = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                if (-nums[i] == nums[j] + nums[k]) {
                    List<Integer> l = List.of(nums[i], nums[j], nums[k]);
                    if (!temp.contains(l)) {
                        temp.add(l);
                        result.add(l);
                    }
                    k--;
                    j++;
                } else if (-nums[i] < nums[j] + nums[k]) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
