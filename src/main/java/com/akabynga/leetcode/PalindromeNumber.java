package com.akabynga.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1001));
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int reversed = 0;

        while (x / 10 != 0 || x % 10 != 0) {
            reversed = reversed == 0 ? x % 10 : reversed * 10 + x % 10;
            x = x / 10;
        }

        return reversed == temp;
    }

    public static boolean isPalindrome1(int x) {

        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
