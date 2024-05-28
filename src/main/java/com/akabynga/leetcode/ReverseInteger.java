package com.akabynga.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = -1203;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        boolean negative = x < 0;
        int result = 0;
        x = Math.abs(x);

        while (x != 0) {
            int lastDigit = x % 10;
            if (result > (Integer.MAX_VALUE - lastDigit) / 10) {
                result = result * 10 + lastDigit;
            }
            x /= 10;
        }
        return negative ? -result : result;
    }

}
