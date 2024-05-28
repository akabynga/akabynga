package com.akabynga.leetcode;

import java.util.ArrayList;
import java.util.List;

//Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
//
//You must write an algorithm that runs in O(n) time and uses O(1) extra space.
//
//Example 1:
//Input: n = 13
//Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

//Example 2:
//Input: n = 2
//Output: [1,2]
public class LexicographicalNumbers {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        dfs(numbers, 0, 21);

        System.out.println(numbers);
    }

    private static void dfs(List<Integer> numbers, int start, int end) {
        for (int i = start; i < start + 10; i++) {
            if (i == 0) {
                continue;
            }
            if (i > end) {
                return;
            }
            numbers.add(i);
            dfs(numbers, i * 10, end);
        }
    }
}
