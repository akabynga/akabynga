package com.akabynga.leetcode;

public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo solution = new PowerOfTwo();
        System.out.println(solution.isPowerOfTwo(7));
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
