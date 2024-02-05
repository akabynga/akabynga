package com.akabynga.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix1(String[] strings) {
        String shortestString = Arrays.stream(strings).min((str1, str2) -> str1.length() > str2.length() ? 1 : -1).get();
        int i = 0;
        initial:
        for (i = 0; i < shortestString.length(); i++) {
            for (String string : strings) {
                if (string == shortestString) {
                    continue;
                }
                if (string.charAt(i) != shortestString.charAt(i)) {
                    break initial;
                }
            }

        }

        return shortestString.substring(0, i);
    }
}
