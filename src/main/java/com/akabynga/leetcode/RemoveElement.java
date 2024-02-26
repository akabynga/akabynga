package com.akabynga.leetcode;

public class RemoveElement {

    public static void main(String[] args) {

        int[] array = {2, 2, 3};
        int target = 2;

        System.out.println(removeElement(array, target));
    }

    public static int removeElement(int[] nums, int val) {
        int result = 0;
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while (leftPointer < nums.length) {
            if (nums[leftPointer] != val) {
                result++;
            } else if (rightPointer >= 0) {
                while (rightPointer > 0 && nums[rightPointer] == val) {
                    rightPointer--;
                }
                nums[leftPointer] = nums[rightPointer];
                rightPointer--;
            }
            leftPointer++;
        }

        return result;
    }

}
