package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] array = {-10, -3, 0, 5, 9};
        System.out.println(createChildren(array, 0, array.length - 1));
    }

    public static TreeNode createChildren(int[] nums, int start, int end) {

        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = createChildren(nums, start, mid - 1);
        node.right = createChildren(nums, mid + 1, end);

        return node;
    }
}
