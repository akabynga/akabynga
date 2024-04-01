package com.akabynga.leetcode;

import com.akabynga.faang.search.BinarySearch;

public class FindFirstAndLastPositionElementSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int foundIndex = BinarySearch.binarySearch(nums, target);

        if (foundIndex == -1) {
            return new int[]{-1, -1};
        }

        int startIndex = foundIndex;
        int endIndex = foundIndex;

        while (startIndex >= 0 && nums[startIndex] == target) {
            startIndex--;
        }

        while (endIndex < nums.length && nums[endIndex] == target) {
            endIndex++;
        }

        return new int[]{startIndex + 1, endIndex - 1};
    }
}
