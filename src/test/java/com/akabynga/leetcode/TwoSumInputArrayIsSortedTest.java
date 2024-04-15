package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumInputArrayIsSortedTest {

    @Test
    public void givenSortedArrayAndTarget_findToIndexesOfNumbersEqualsToTarget_returnArrayWithTwoIndexes() {

        // arrange
        TwoSumInputArrayIsSorted solution = new TwoSumInputArrayIsSorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 2};

        // act
        int[] result = solution.twoSum(numbers, target);

        // assert
        Assertions.assertArrayEquals(expected, result);

    }
}
