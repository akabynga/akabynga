package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getTreeDepth(root.left, 0) - getTreeDepth(root.right, 0)) <= 1;
    }

    public static int getTreeDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        depth++;

        return Math.max(getTreeDepth(node.left, depth), getTreeDepth(node.right, depth));
    }
}
