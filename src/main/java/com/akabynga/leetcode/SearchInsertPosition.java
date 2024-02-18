package com.akabynga.leetcode;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6};
        int target = 5;

        System.out.println(searchInsert(array, target));
    }

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }

    public static int binarySearch(int[] array, int target, int start, int end) {

        int median = (end + start) / 2;

        if (median >= array.length || array[median] == target) {
            return median;
        }
        int distance = end - start;

        if (distance <= 1) {
            return target < array[median] ? median : median + 1;
        } else if (target > array[median]) {
            return binarySearch(array, target, median + 1, end);
        } else if (target < array[median]) {
            return binarySearch(array, target, start, median);
        } else {
            return -1;
        }
    }
}
