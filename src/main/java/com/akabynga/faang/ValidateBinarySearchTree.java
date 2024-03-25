package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;
import edu.princeton.cs.introcs.In;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return checkIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkIsValidBST(TreeNode node, Long bottomBorder, Long upperBorder) {
        if (node == null) {
            return true;
        }

        if (node.val <= bottomBorder || node.val >= upperBorder) {
            return false;
        }

        return checkIsValidBST(node.left, bottomBorder, (long) node.val) && checkIsValidBST(node.right, (long) node.val, upperBorder);
    }
}
