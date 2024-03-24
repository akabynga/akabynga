package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountCompleteTreeNodesTest {


    @Test
    public void givenTree_countNumberOfTreeNodes() {

        // arrange
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
        Integer[] array = {1, 2, 3, 4, 5, 6};
        TreeNode root = TreeNode.intArrayToTreeNode(array);
        int expectedResult = array.length;

        // act
        int actualResult = solution.countNodes(root);

        // assert
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void givenEmptyTree_countNumberOfTreeNodes() {

        // arrange
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
        Integer[] array = {};
        TreeNode root = TreeNode.intArrayToTreeNode(array);
        int expectedResult = array.length;

        // act
        int actualResult = solution.countNodes(root);

        // assert
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void givenTreeWithOnlyRootNode_countNumberOfTreeNodesEqual_1() {

        // arrange
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
        Integer[] array = {1};
        TreeNode root = TreeNode.intArrayToTreeNode(array);
        int expectedResult = array.length;

        // act
        int actualResult = solution.countNodes(root);

        // assert
        Assertions.assertEquals(expectedResult, actualResult);

    }
}
