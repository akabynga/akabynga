package com.akabynga.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMedian {

    public static void main(String[] args) {

        int[] nums = {1, 4, 2, 3};
        int k = 4;

        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];
        Deque<Integer> window = new ArrayDeque<>();
        int rCounter = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r >= k) {
                result[rCounter++] = getMedian(window, nums);
            }
            if (!window.isEmpty() && window.peek() <= r - k) {
                window.removeFirst();
            }
            window.addLast(r);
        }
        result[rCounter] = getMedian(window, nums);
        return result;
    }


    private static double getMedian(Deque<Integer> window, int[] nums) {
        int[] subarray = window.stream().mapToInt(index -> nums[index]).sorted().toArray();
        System.out.println(Arrays.toString(subarray));
        if (subarray.length % 2 == 0) {
            return getMedianForEven(subarray);
        } else {
            return getMedianForOdd(subarray);
        }
    }

    private static double getMedianForEven(int[] subarray) {
        return ((double) subarray[subarray.length / 2 - 1]) / 2 + ((double) subarray[subarray.length / 2]) / 2;
    }

    private static double getMedianForOdd(int[] subarray) {
        return subarray[(subarray.length / 2)];
    }
}
