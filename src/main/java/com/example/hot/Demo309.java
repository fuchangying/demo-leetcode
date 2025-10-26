package com.example.hot;

public class Demo309 {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // f[i][0]: 手上持有股票的最大收益
            // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益-今天卖出
            // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

}
