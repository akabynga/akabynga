package com.akabynga.leetcode;

public class BestTimeToBuyAndSellStocks2 {
    public static void main(String[] args) {

        int[] array = {7, 1, 5, 3, 6, 4, 1, 2};
        System.out.println(maxProfit(array));

    }

    public static int maxProfit(int[] prices) {
        int totalProfit = 0;

        // checking if previous element is less than current,  just add the difference
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += (prices[i] - prices[i - 1]);
                i++;
            }
        }
        return totalProfit;
    }
}