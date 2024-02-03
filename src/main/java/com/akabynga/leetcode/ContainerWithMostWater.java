package com.akabynga.leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(array));
    }

    public static int maxArea(int[] array) {
        int left = 0;
        int right = array.length - 1;

        int maxArea = 0;
        while (left < right) {
            int currentArea = Math.min(array[left], array[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (array[left] < array[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
