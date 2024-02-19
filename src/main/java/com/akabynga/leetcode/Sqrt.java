package com.akabynga.leetcode;

public class Sqrt {

    public static void main(String[] args) {
        int x = 2147395599;

        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }

        int start = 1;
        int end = x / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid > x / mid) {
                end = mid - 1;
            } else if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid < x / mid) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
