package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        traverseAndLog(root, result, "");
        return result;
    }

    public void traverseAndLog(TreeNode node, List<String> list, String s) {

        if (node == null) {
            return;
        }
        s += !s.isEmpty() ? "->" + node.val : node.val;

        if (node.left == null && node.right == null) {
            list.add( s);
        }

        traverseAndLog(node.left, list, s);
        traverseAndLog(node.right, list, s);
    }
}
