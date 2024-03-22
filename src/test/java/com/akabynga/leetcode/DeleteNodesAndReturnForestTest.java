package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForestTest {


    @Test
    public void deleteNodesAndReturnForestTest() {

        // arrange
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] to_delete = {3, 5};

        List<TreeNode> expectedResult = List.of(TreeNode.intArrayToTreeNode(new Integer[]{1, 2, null, 4}), new TreeNode(6), new TreeNode(7));

        TreeNode root = TreeNode.intArrayToTreeNode(array);
        TreeNode.displayHorizontalOrder(root);

        DeleteNodesAndReturnForest solution = new DeleteNodesAndReturnForest();

        // act
        List<TreeNode> result = solution.delNodes(root, to_delete);
        System.out.println(result);

        // assert
//        Assertions.assertEquals(expectedResult, result);

    }
}
