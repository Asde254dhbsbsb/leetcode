package Dynamicprogramming.BestTimetoBuyandSellStockII122;

public class DPSolution {
    // 动态规划:第i天只有两种状态:持有股票和没有股票
    // 持有股票的话：dp[i][1] = Max(dp[i - 1][1], dp[i-1][0] - prices[i])// 昨天已经持有，昨天没有今天刚买
    // 没有股票的话：dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + prices[i]) // 昨天持有今天卖出或者保持没有股票现状
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }
}
