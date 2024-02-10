package com.akabynga.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int j = 0;
        int[] ans = new int[nums.length - k + 1];
        int i = 0;

        for (int index = 0; index < nums.length; index++) {
            if (index >= k) {
                ans[j++] = nums[q.peek()];
            }
            while (!q.isEmpty() && q.peek() <= index - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && nums[index] >= nums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(index);
        }
        ans[j] = nums[q.peek()];
        return ans;
    }

}
