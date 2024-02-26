package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invertNode(root);
        return root;
    }

    public void invertNode(TreeNode node) {

        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertNode(node.left);
        invertNode(node.right);
    }
}
