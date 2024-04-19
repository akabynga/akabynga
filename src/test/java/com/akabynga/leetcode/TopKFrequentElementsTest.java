package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopKFrequentElementsTest {

    @Test
    public void givenArrayOfElementsAndK_findTopKFrequentElements() {

        // arrange
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] array = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 2};

        // act
        int[] result = solution.topKFrequent(array, k);

        // assert
        Assertions.assertArrayEquals(expected, result);
    }

}
