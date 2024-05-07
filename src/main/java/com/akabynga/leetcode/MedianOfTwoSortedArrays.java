package com.akabynga.leetcode;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int combinedLength = nums1.length + nums2.length;

        int start = 0;
        int end = nums1.length;

        while (start <= end) {

            int partX = (start + end) / 2;
            int partY = (combinedLength + 1) / 2 - partX;

            int leftX = getMax(nums1, partX);
            int rightX = getMin(nums1, partX);

            int leftY = getMax(nums2, partY);
            int rightY = getMin(nums2, partY);

            if (leftX <= rightY && leftY <= rightX) {
                if (combinedLength % 2 == 0) {
                    return (Math.max(leftY, leftX) + Math.min(rightX, rightY)) / 2.0;
                }
                return Math.max(leftY, leftX);
            }
            if (leftX > rightY) {
                end = partX - 1;
            } else {
                start = partX + 1;
            }
        }
        return -1;
    }


    private int getMax(int[] nums, int partition) {
        return partition == 0 ? Integer.MIN_VALUE : nums[partition - 1];
    }

    private int getMin(int[] nums, int partition) {
        return partition == nums.length ? Integer.MAX_VALUE : nums[partition];
    }
}
