package com.akabynga.leetcode;

public class ValidPalindrome {
    final static int difference = Math.abs('A' - 'a');

    public static void main(String[] args) {
        System.out.println(difference);
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char leftChar = toLowerCase(s.charAt(left));
            char rightChar = toLowerCase(s.charAt(right));

            if (!isAlphanumeric(leftChar)) {
                left++;
                continue;
            }
            if (!isAlphanumeric(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    private static char toLowerCase(char c) {
        return c >= 'A' && c <= 'Z' ? (char) (c + difference) : c;
    }


    private static boolean isAlphanumeric(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }
}
