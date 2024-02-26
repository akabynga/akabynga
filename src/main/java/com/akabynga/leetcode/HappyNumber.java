package com.akabynga.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int number = n;
        while (number != 1) {
            int localNumber = number;
            int sum = 0;
            while (localNumber / 10 != 0 || localNumber % 10 != 0) {
                sum += (int) Math.pow(localNumber % 10, 2);
                localNumber /= 10;
            }
            number = sum;
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
        }
        return true;
    }
}
