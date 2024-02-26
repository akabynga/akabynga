package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        Integer[] array = {1, null, 2, 3};
        //TODO write function to convert array to Tree

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traverse(root, result);


        return result;
    }

    public void traverse(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        list.add(node.val);

        traverse(node.left, list);
        traverse(node.right, list);
    }
}
