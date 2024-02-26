package com.akabynga.leetcode;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sToT = new int[128];
        int[] tToS = new int[128];

        for (int i = 0; i < t.length(); i++) {
            if (sToT[t.charAt(i)] != tToS[s.charAt(i)]) {
                return false;
            }

            sToT[t.charAt(i)] = i + 1;
            tToS[s.charAt(i)] = i + 1;

        }

        return true;
    }
}
