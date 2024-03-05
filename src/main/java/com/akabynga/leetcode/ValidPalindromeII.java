package com.akabynga.leetcode;

public class ValidPalindromeII {

    public static void main(String[] args) {

        String s = "ebcbbececabbacecbbcbe";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left, right - 1)) {
                    return true;
                } else if (isPalindrome(s, left + 1, right)) {
                    return true;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
