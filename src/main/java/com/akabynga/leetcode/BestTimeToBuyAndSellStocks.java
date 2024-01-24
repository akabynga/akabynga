package com.akabynga.leetcode;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {

        int[] array = {7, 1, 5, 3, 6, 4, 1, 2};
        System.out.println(maxProfit(array));

    }

    public static int maxProfit(int[] prices) {
        int lsf = prices[0]; // least so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lsf) { // if we found new buy value which is smaller than previous one
                lsf = prices[i]; // update our least so far
            }
            pist = prices[i] - lsf; // calculating profit if sold today by, Buy - sell
            if (op < pist) { // if pist is more than our previous overall profit
                op = pist; // update overall profit
            }
        }
        return op; // return op
    }
}