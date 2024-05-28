package com.akabynga.leetcode;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String input) {
        char[] arr = input.toCharArray();
        int[] freq = new int[26];
        for (char ch : arr) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (freq[ch - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
