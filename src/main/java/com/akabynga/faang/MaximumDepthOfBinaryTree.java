package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }

    public int getMaxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(getMaxDepth(node.left, depth + 1), getMaxDepth(node.right, depth + 1));
    }

}
