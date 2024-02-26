package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
}
