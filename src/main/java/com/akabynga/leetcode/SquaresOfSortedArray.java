package com.akabynga.leetcode;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while (left <= right) {
            if (square(nums[left]) <= square(nums[right])) {
                result[index--] = square(nums[right--]);
            } else {
                result[index--] = square(nums[left++]);
            }
        }
        return result;
    }

    public static int square(int number) {
        return number * number;
    }
}
