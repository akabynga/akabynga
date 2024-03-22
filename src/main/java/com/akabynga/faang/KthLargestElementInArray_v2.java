package com.akabynga.faang;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInArray_v2 {
    // not effective enough
    public static int findKthLargest(int[] nums, int k) {
        int indexToFind = nums.length - k;
        quickSort(nums, 0, nums.length - 1);
        return nums[indexToFind];
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {

        int pivot = array[right];
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, partitionIndex, i);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, right);

        return partitionIndex;
    }


    private static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
