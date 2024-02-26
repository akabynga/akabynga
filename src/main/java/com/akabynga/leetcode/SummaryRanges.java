package com.akabynga.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] array = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges1(array));
    }
    public static List<String> summaryRanges1(int[] nums) {
        if(nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        int left = 0;
        int right = 1;
        while(right < nums.length) {
            if (nums[right - 1] + 1 != nums[right]) {
                result.add(getResult(nums, left, right - 1));
                left = right;
            }
            right++;
        }

        result.add(getResult(nums, left, nums.length - 1));

        return result;
    }

    public static String getResult(int[] nums, int left, int right) {
        if (right - left < 1) {
            return String.valueOf(nums[left]);
        } else {
            return nums[left] + "->" + nums[right];
        }
    }
}
