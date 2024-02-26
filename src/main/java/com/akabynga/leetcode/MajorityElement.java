package com.akabynga.leetcode;

public class MajorityElement {

    public static void main(String[] args) {

        int[] array = {1, 2, 2, 2, 2, 2, 2, 2, 1, 3, 4, 5, 6, 7, 8, 9, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println(majorityElement(array));
    }

    public static int majorityElement(int[] nums) {

        int count = 0;
        int candidate = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }

            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

}
