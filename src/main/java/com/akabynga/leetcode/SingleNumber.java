package com.akabynga.leetcode;

public class SingleNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2, 3, 4};
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
