package com.akabynga.leetcode;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(BinaryTreeInorderTraversal.TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(BinaryTreeInorderTraversal.TreeNode left, BinaryTreeInorderTraversal.TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
