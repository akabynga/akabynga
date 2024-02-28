package com.akabynga.faang;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea_brutForce(array));
    }

    public static int maxArea(int[] array) {

        int left = 0;
        int right = array.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(array[left], array[right]) * (right - left));
            if (array[left] < array[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static int maxArea_brutForce(int[] array) {
        int maxArea = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                maxArea = Math.max(maxArea, Math.min(array[i], array[j]) * (j - i));
            }
        }

        return maxArea;
    }
}
