package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> result = new ArrayList<>();

        Set<Integer> nodesForRemove = new HashSet<>();
        for (int val : to_delete) {
            nodesForRemove.add(val);
        }
        traverse(root, nodesForRemove, result, true);

        return result;
    }

    private TreeNode traverse(TreeNode node, Set<Integer> nodesForRemove, List<TreeNode> result, boolean parentEmpty) {
        if (node == null) {
            return null;
        }
        if (parentEmpty && !nodesForRemove.contains(node.val)) {
            result.add(node);
        }

        boolean willBeRemoved = nodesForRemove.contains(node.val);
        node.left = traverse(node.left, nodesForRemove, result, willBeRemoved);
        node.right = traverse(node.right, nodesForRemove, result, willBeRemoved);

        if (willBeRemoved) {
            return null;
        }

        return node;
    }
}
