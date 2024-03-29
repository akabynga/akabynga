package com.akabynga.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//        Example 1:
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.

//        Example 2:
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.

//        Example 3:
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class LongestSubstring {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("dvdf")); // 3
        System.out.println(lengthOfLongestSubstring_hashmap("dvdf")); // 3
    }

    public static int lengthOfLongestSubstring(String string) {

        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;

        for (int right = 0; right < string.length(); right++) {
            while (!set.add(string.charAt(right))) {
                set.remove(string.charAt(left++));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring_hashmap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int right = 0; right < string.length(); right++) {
            if (map.containsKey(string.charAt(right)) && map.get(string.charAt(right)) >= left) {
                left = map.get(string.charAt(right)) + 1;
            } else {
                max = Math.max(max, right - left + 1);
            }
            map.put(string.charAt(right), right);
        }
        return max;
    }
}
