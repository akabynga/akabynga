package com.akabynga.leetcode;

public class SameTree {
    //https://leetcode.com/problems/same-tree/
    public static void main(String[] args) {

    }

    public boolean isSameTree(BinaryTreeInorderTraversal.TreeNode p, BinaryTreeInorderTraversal.TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
