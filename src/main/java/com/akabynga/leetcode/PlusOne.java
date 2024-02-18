package com.akabynga.leetcode;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] array = {9};
        System.out.println(Arrays.toString(plusOne(array)));
    }

    public static int[] plusOne(int[] digits) {

        int addition = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (addition + digits[i] > 9) {
                addition = 1;
            } else {
                addition = 0;
            }
        }
        int[] result;
        if (digits[0] + addition > 9) {
            result = new int[digits.length + 1];
        } else {
            result = new int[digits.length];
        }
        addition = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (addition + digits[i] > 9) {
                addition = 1;
                result[i] = 0;
            } else {
                result[i] = addition + digits[i];
                addition = 0;
            }
        }
        if (digits.length < result.length && addition == 1) {
            result[0] = addition;
        }

        return result;
    }
}
