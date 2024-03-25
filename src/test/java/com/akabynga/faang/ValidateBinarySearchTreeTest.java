package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateBinarySearchTreeTest {

    @Test
    public void givenNotValidBinaryTree_checkIsValidBinaryTree() {

        // arrange
        Integer[] array = {5, 1, 4, null, null, 3, 6};
        TreeNode root = TreeNode.intArrayToTreeNode(array);
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        // act
        boolean actualResult = solution.isValidBST(root);

        // assert
        Assertions.assertFalse(actualResult);

    }
}
