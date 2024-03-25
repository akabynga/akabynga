package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TreeNodeTest {

    @Test
    public void giverTree_whenAddedToResultArrayAllNodesUsingBFS_thenCompareArrays() {

        // arrange
        Integer[] initialArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.intArrayToTreeNode(initialArray);
        Integer[] result = new Integer[10];
        AtomicInteger index = new AtomicInteger();

        // act
        root.breadthFirstSearch(value -> result[index.getAndIncrement()] = value);

        // assert
        Assertions.assertArrayEquals(initialArray, result);
    }

    @Test
    public void giverTree_whenAddedToResultArrayAllNodesUsingDFS_preOrder_thenCompareArrays() {

        // arrange
        Integer[] initialArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.intArrayToTreeNode(initialArray);
        Integer[] result = new Integer[10];
        AtomicInteger index = new AtomicInteger();
        Integer[] expected = {1, 2, 4, 8, 9, 5, 10, 3, 6, 7};

        // act
        root.depthFirstSearchPreOrder(value -> result[index.getAndIncrement()] = value);

        // assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void giverTree_whenAddedToResultArrayAllNodesUsingDFS_inOrder_thenCompareArrays() {

        // arrange
        Integer[] initialArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.intArrayToTreeNode(initialArray);
        Integer[] result = new Integer[10];
        AtomicInteger index = new AtomicInteger();
        Integer[] expected = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};

        // act
        root.depthFirstSearchInOrder(value -> result[index.getAndIncrement()] = value);

        // assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void giverTree_whenAddedToResultArrayAllNodesUsingDFS_postOrder_thenCompareArrays() {

        // arrange
        Integer[] initialArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.intArrayToTreeNode(initialArray);
        Integer[] result = new Integer[10];
        AtomicInteger index = new AtomicInteger();
        Integer[] expected = {8, 9, 4, 10, 5, 2, 6, 7, 3, 1};

        // act
        root.depthFirstSearchPostOrder(value -> result[index.getAndIncrement()] = value);

        // assert
        Assertions.assertArrayEquals(expected, result);
    }
}
