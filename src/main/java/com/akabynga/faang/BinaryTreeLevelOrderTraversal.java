package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfsWithLevelOrder(root);
    }

    private List<List<Integer>> bfsWithLevelOrder(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int length = queue.size();
            int count = 0;
            ArrayList<Integer> currentLevelValues = new ArrayList<>();

            while (count < length) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                currentLevelValues.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count++;
            }
            result.add(currentLevelValues);
        }
        return result;
    }

}
