package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int height = TreeNode.countCompleteTreeHeight(root);
        if (height == 0) {
            return 1;
        }

        int upperCount = TreeNode.calculateMaxCountNodesInFullCompleteTree(height);
        int left = 0;
        int right = upperCount;
        while (left < right) {
            int indexToFind = (int) Math.ceil((double) (left + right) / 2);
            if (nodeExists(indexToFind, height, root)) {
                left = indexToFind;
            } else {
                right = indexToFind - 1;
            }
        }

        return upperCount + left + 1;
    }

    private boolean nodeExists(int indexToFind, int height, TreeNode node) {
        if (node == null) {
            return false;
        }
        int left = 0;
        int right = (int) Math.pow(2, height) - 1;
        int count = 0;

        while (count < height) {
            int midOfNode = (int) Math.ceil((double) (left + right) / 2);
            if (indexToFind >= midOfNode) {
                node = node.right;
                left = midOfNode;
            } else {
                node = node.left;
                right = midOfNode - 1;
            }
            count++;
        }
        return node != null;
    }
}
