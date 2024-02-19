package com.akabynga.leetcode;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public int maxDepth(BinaryTreeInorderTraversal.TreeNode root) {
        return getMaxDepth(root, 0);
    }

    public int getMaxDepth(BinaryTreeInorderTraversal.TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(getMaxDepth(node.left, depth + 1), getMaxDepth(node.right, depth + 1));
    }

}
