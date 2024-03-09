package com.akabynga.leetcode;

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(isUgly(2));
    }

    public static boolean isUgly(int n) {

        if (n == 0) {
            return false;
        }

        for (int i = 2; i <= 5; i++) {
            while (n % i == 0) {
                n /= i;
            }
        }

        return n == 1;
    }
}
