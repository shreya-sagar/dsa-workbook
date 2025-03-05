package com.dev.leetcode;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int size = prices.length;
        if (size == 1)
            return 0;
        int profit = 0;

        int[] max = new int[size];
        max[size - 1] = prices[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            max[i] = Math.max(prices[i], max[i + 1]);
        }

        for (int i = 0; i < size - 1; i++) {
            if ((max[i + 1] - prices[i]) > profit)
                profit = max[i + 1] - prices[i];
        }
        return profit;
    }

    //Good Solution From Submissions
    public int maxProfitOptimized(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};//output 5
        System.out.println(maxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};//output 0
        System.out.println(maxProfit(prices));
    }


}
