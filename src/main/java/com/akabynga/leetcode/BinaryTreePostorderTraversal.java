package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    public void traverse(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        traverse(node.left, list);
        traverse(node.right, list);
        list.add(node.val);
    }
}
