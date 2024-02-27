package com.akabynga.faang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] arr = {1, 3, 1, 2, 3, 6, 3, 7, 9, 5};
        int target = 14;

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static int[] twoSum(int[] array, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[]{i, map.get(target - array[i])};
            }
            map.put(i, array[i]);
        }

        return null;
    }

    public static int[] twoSum_bruteForce(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == target - array[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
