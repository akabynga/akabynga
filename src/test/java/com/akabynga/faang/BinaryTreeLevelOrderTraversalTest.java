package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreeLevelOrderTraversalTest {

    @Test
    public void givenBinaryTree_thenGetLevelOrderTraversal() {

        // arrange
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.intArrayToTreeNode(array);
        List<List<Integer>> expectedResult = List.of(List.of(3), List.of(9, 20), List.of(15, 7));

        // act
        List<List<Integer>> actualResult = solution.levelOrder(root);

        // assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
