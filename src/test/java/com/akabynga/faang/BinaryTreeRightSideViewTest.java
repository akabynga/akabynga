package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreeRightSideViewTest {


    @Test
    public void givenBinaryTree_returnRightSideView() {

        // arrange
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        Integer[] array = {1, 2, 3, null, 5, null, 4};
        TreeNode root = TreeNode.intArrayToTreeNode(array);
        List<Integer> expectedResult = List.of(1, 3, 4);

        // act
        List<Integer> actualResult = solution.rightSideView_dfs(root);

        // assert
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
