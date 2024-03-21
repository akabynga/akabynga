package com.akabynga.faang;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInArray {


    public static int findKthLargest_PriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1);

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

    public static int findKthLargest(int[] nums, int k) {

        Random rand = new Random();

        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int newPivotIndex = partition(nums, left, right, pivotIndex);

            if (newPivotIndex == nums.length - k) {
                return nums[newPivotIndex];
            } else if (newPivotIndex > nums.length - k) {
                right = newPivotIndex - 1;
            } else {
                left = newPivotIndex + 1;
            }
        }
        return -1;
    }

    private static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);

        int storedIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, i, storedIndex);
                storedIndex++;
            }
        }

        swap(array, right, storedIndex);
        return storedIndex;
    }

    private static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
