package com.akabynga.leetcode;

import java.util.HashMap;
import java.util.Map;

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

    public boolean isIsomorphic(String source, String target) {

        if (source.length() != target.length()) {
            return false;
        }

        Map<Character, Character> mapSourceToTarget = new HashMap<>();
        Map<Character, Character> mapTargetToSource = new HashMap<>();

        for (int i = 0; i < target.length(); i++) {

            if (!mapTargetToSource.containsKey(target.charAt(i))) {
                mapTargetToSource.put(target.charAt(i), source.charAt(i));
            }
            if (!mapSourceToTarget.containsKey(source.charAt(i))) {
                mapSourceToTarget.put(source.charAt(i), target.charAt(i));
            }

            if (mapTargetToSource.get(target.charAt(i)) != source.charAt(i) || mapSourceToTarget.get(source.charAt(i)) != target.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
