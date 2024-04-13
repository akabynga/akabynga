package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

public class KthSmallestElementInBST {
    private int result = -1;
    private int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }


    public void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        dfs(node.left, k);
        counter++;

        if (counter == k) {
            result = node.val;
            return;
        }
        dfs(node.right, k);
    }
}
