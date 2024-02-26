package com.akabynga.leetcode;


import javax.swing.tree.TreeNode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode node) {
        return traverse(node);
    }

    public int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return traverse(node.left) + traverse(node.right) + 1;
    }
}
