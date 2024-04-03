package com.akabynga.faang;

import com.akabynga.leetcode.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinChangeTest {

    @Test
    public void givenArrayOfCoinsAndAmount_countNumberOfCoinsWeNeedToGetAmount() {

        // arrange
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expectedResult = 3;

        // act
        int actualResult = solution.coinChange(coins, amount);

        // assert
        Assertions.assertEquals(expectedResult, actualResult);

    }
}
