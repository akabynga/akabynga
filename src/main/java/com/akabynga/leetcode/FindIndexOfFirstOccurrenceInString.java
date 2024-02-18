package com.akabynga.leetcode;

public class FindIndexOfFirstOccurrenceInString {
    public static void main(String[] args) {
        String haystack = "1sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        return lpsApproach(haystack, needle);
    }

    public static int lpsApproach(String haystack, String needle) {
        int[] lps = new int[needle.length()];
        int pre = 0;

        for (int i = 1; i < needle.length(); i++) {
            while (pre > 0 && needle.charAt(i) != needle.charAt(pre)) {
                pre = lps[pre - 1];
            }
            if (needle.charAt(pre) == needle.charAt(i)) {
                pre += 1;
                lps[i] = pre;
            }
        }

        int n = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (n > 0 && needle.charAt(n) != haystack.charAt(i)) {
                n = lps[n - 1];
            }
            if (needle.charAt(n) == haystack.charAt(i)) {
                n += 1;
            }
            if (n == needle.length()) {
                return i - n + 1;
            }
        }
        return -1;
    }

    public static int libSolution(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int mySolution(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int innerPointer = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(innerPointer)) {
                innerPointer++;
            } else {
                i -= innerPointer;
                innerPointer = 0;
            }
            if (innerPointer == needle.length()) {
                return i - innerPointer + 1;
            }
        }

        return -1;
    }
}
