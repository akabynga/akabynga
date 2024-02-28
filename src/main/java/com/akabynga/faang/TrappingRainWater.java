package com.akabynga.faang;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        System.out.println(trap(array));
    }

    public static int trap(int[] height) {
        int totalWater = 0;

        int left = 0;
        int right = height.length - 1;

        int maxLeft = height[left];
        int maxRight = height[right];

        while (left < right) {

            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                totalWater += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                totalWater += maxRight - height[right];
            }
        }

        return totalWater;
    }

    public static int trap_brutForce(int[] height) {
        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {

            int left = i;
            int right = i;
            int maxLeft = height[i];
            int maxRight = height[i];

            while (left >= 0) {
                maxLeft = Math.max(maxLeft, height[left]);
                left--;
            }
            while (right < height.length) {
                maxRight = Math.max(maxRight, height[right]);
                right++;
            }

            int currentWater = Math.min(maxLeft, maxRight) - height[i];

            if (currentWater > 0) {
                totalWater += currentWater;
            }
        }


        return totalWater;
    }
}
