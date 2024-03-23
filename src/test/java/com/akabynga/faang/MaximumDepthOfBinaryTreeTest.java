package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumDepthOfBinaryTreeTest {


    @Test
    public void givenBinaryTree_findMaxDepth() {

        // arrange
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        int result = 3;
        TreeNode node = TreeNode.intArrayToTreeNode(array);

        // act
        int actualResult = solution.maxDepth(node);

        // assert
        Assertions.assertEquals(result, actualResult);
    }
}
