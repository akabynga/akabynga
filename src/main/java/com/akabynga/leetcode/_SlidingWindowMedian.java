package com.akabynga.leetcode;

import java.util.*;

public class _SlidingWindowMedian {


    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) {

        int[] nums = {1, 4, 2, 3};
        int k = 4;


        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(9);
        minHeap.add(1);

        maxHeap.add(4);
        maxHeap.add(2);
        maxHeap.add(9);
        maxHeap.add(1);

        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0];
        double[] result = new double[n];
        for (int r = 0; r <= nums.length; r++) {
            if (r >= k) {
                result[r - k] = getMedian();
                remove(nums[r - k]);
            }
            if (r < nums.length) {
                add(nums[r]);
            }
        }
        return result;
    }

    private static void add(int element) {
        if (element < getMedian()) {
            maxHeap.add(element);
        } else {
            minHeap.add(element);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private static void remove(int element) {
        if (element < getMedian()) {
            maxHeap.remove(element);
        } else {
            minHeap.remove(element);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }


    private static double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() / 2.0) + ((double) minHeap.peek() / 2.0);
        } else {
            return (double) minHeap.peek();
        }
    }
}
