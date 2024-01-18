package com.akabynga.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

        int[] array = {1, 2, 2};
        int test = removeDuplicates(array);
        System.out.println(test);
        System.out.println(Arrays.toString(array));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int lastUnique = nums[0];
        int index = 1;

        while (index < nums.length) {
            if (nums[index] <= lastUnique) {
                int current = index;
                while (current < nums.length - 1 && nums[current] <= lastUnique) {
                    current++;
                }
                if (current == nums.length - 1 && nums[current] <= lastUnique) {
                    break;
                }
                int temp = nums[index];
                nums[index] = nums[current];
                nums[current] = temp;
            }
            lastUnique = nums[index++];
        }
        return index;
    }
}
