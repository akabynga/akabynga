package com.akabynga.leetcode;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {

        int[] array = {7, 1, 5, 3, 6, 4, 1, 2};
        System.out.println(maxProfit(array));

    }

    public static int maxProfit(int[] prices) {
        int leastSoFar = prices[0];
        int overallProfit = 0;
        int profitIfSoldToday = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < leastSoFar) { // if we found new buy value which is smaller than previous one
                leastSoFar = prices[i]; // update our least so far
            }
            profitIfSoldToday = prices[i] - leastSoFar; // calculating profit if sold today by, Buy - sell
            if (overallProfit < profitIfSoldToday) { // if pist is more than our previous overall profit
                overallProfit = profitIfSoldToday; // update overall profit
            }
        }
        return overallProfit;
    }
}