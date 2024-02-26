package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

public class MinimumDepthOfBinaryTree {

    private static final int NOT_SUITABLE = 100001;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root, 0);
    }

    public int minDepth(TreeNode node, int depth) {
        if (node == null) {
            return NOT_SUITABLE; // mark as not suitable
        }

        depth++;
        if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.min(minDepth(node.left, depth), minDepth(node.right, depth));
    }
}
