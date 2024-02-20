package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

public class PathSum {

    public static void main(String[] args) {
        System.out.println(hasPathSum(new TreeNode(5), 5));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null || root.val != targetSum && isLeaf(root)) {
            return false;
        }
        return fitPathSum(root, targetSum);
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static boolean fitPathSum(TreeNode node, int targetSum) {

        if (targetSum == node.val && isLeaf(node)) {
            return true;
        }

        return node.left != null && fitPathSum(node.left, targetSum - node.val) ||
                node.right != null && fitPathSum(node.right, targetSum - node.val);
    }
}
