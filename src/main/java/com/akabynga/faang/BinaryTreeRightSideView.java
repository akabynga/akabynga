package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView_dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traverse(root, result, 0);

        return result;
    }

    private void traverse(TreeNode node, List<Integer> result, int level) {

        if (node == null) {
            return;
        }

        if (level == result.size()) {
            result.add(node.val);
        }

        traverse(node.right, result, level + 1);
        traverse(node.left, result, level + 1);
    }

    public List<Integer> rightSideView_bfs(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int length = queue.size();
            int count = 0;
            TreeNode node = null;
            while (count < length) {
                node = queue.poll();
                if (node == null) {
                    continue;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                count++;
            }
            result.add(node.val);
        }

        return result;
    }
}
