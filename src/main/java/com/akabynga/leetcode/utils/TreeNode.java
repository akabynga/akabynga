package com.akabynga.leetcode.utils;

import java.util.Arrays;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    /**
     * Transform int array like [1, 2, 3, 4, 5, 6, 7] to binary tree:
     * 1
     * |     \
     * 2       3
     * | \     | \
     * 4   5   6   7
     */


    public static void displayVerticalOrder(TreeNode root) {
        _displayVerticalOrder(root);
        System.out.println();
    }

    private static void _displayVerticalOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        displayVerticalOrder(root.left);
        displayVerticalOrder(root.right);
    }

    public static void displayHorizontalOrder(TreeNode root) {

        LinkedList<TreeNode> peaks = new LinkedList<>();
        peaks.addLast(root);

        while (!peaks.isEmpty()) {
            TreeNode node = peaks.removeFirst();
            System.out.print(node);
            System.out.print(" ");
            if (node != null) {
                if (node.left != null) {
                    peaks.addLast(node.left);
                }
                if (node.right != null) {
                    peaks.addLast(node.right);
                }
            }
        }
        System.out.println();
    }

    public static TreeNode intArrayToTreeNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        LinkedList<Integer> numbers = new LinkedList<>();

        Arrays.stream(array).forEach(numbers::addLast);

        TreeNode root = new TreeNode(numbers.removeFirst());
        createTreePeak(root, numbers);

        return root;
    }

    private static void createTreePeak(TreeNode parent, LinkedList<Integer> numbers) {

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.push(parent);

        while (!numbers.isEmpty()) {
            TreeNode node = nodes.removeFirst();

            if (node == null) {
                continue;
            }

            if (!numbers.isEmpty()) {
                Integer value = numbers.removeFirst();
                node.left = value == null ? null : new TreeNode(value);
                nodes.addLast(node.left);
            }
            if (!numbers.isEmpty()) {
                Integer value = numbers.removeFirst();
                node.right = value == null ? null : new TreeNode(value);
                nodes.addLast(node.right);
            }
        }
    }
}