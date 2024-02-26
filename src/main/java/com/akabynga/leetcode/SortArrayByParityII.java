package com.akabynga.leetcode;

import java.util.Arrays;

public class SortArrayByParityII {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    public static int[] sortArrayByParityII(int[] nums) {

        int evenPointer = 0;
        int oddPointer = 1;

        while (evenPointer < nums.length && oddPointer < nums.length) {
            while (evenPointer < nums.length && nums[evenPointer] % 2 == 0) {
                evenPointer += 2;
            }
            while (oddPointer < nums.length && nums[oddPointer] % 2 == 1) {
                oddPointer += 2;
            }

            if (evenPointer < nums.length && oddPointer < nums.length) {
                int temp = nums[evenPointer];
                nums[evenPointer] = nums[oddPointer];
                nums[oddPointer] = temp;
            }

        }

        return nums;
    }
}
