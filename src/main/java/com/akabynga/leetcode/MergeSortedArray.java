package com.akabynga.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0, 0, 0};
        int m = 0;
        int[] nums2 = {1, 2, 3, 4, 5};
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }

        int firstPointer = m - 1;
        int secondPointer = n - 1;
        int index = nums1.length - 1;
        while (firstPointer >= 0 || secondPointer >= 0) {

            if (firstPointer < 0) {
                nums1[index--] = nums2[secondPointer--];
                continue;
            }
            if (secondPointer < 0) {
                nums1[index--] = nums1[firstPointer--];
                continue;
            }

            if (nums1[firstPointer] >= nums2[secondPointer]) {
                nums1[index--] = nums1[firstPointer--];
            } else {
                nums1[index--] = nums2[secondPointer--];
            }
        }
    }
}
