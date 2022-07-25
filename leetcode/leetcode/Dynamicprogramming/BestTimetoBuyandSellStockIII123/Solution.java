package BestTimetoBuyandSellStockIII123;

class Solution {
    public int maxProfit(int[] prices) {

        int[][] dp1 = new int[prices.length][4];
        dp1[0][0] = -prices[0];
        dp1[0][1] = 0;
        dp1[1][2] = -prices[0];
        dp1[0][3] = 0;

        for(int i = 1; i < prices.length; i++) {
            dp1[i][0] = Math.max(- prices[i], dp1[i-1][0]);
            dp1[i][1] = Math.max(dp1[i-1][0] + prices[i], dp1[i-1][1]);
            dp1[i][2] = Math.max(dp1[i-1][1] - prices[i], dp1[i-1][2]);
            dp1[i][3] = Math.max(dp1[i-1][2] + prices[i], dp1[i-1][3]);
        }
        
        return Math.max(dp1[prices.length - 1][1], dp1[prices.length][3]);
    }
    // 修改一下改成二维的？
}        
        // int[][][] dp = new int[prices.length][2][3];
        // dp[0][0][0] = 0;
        // dp[0][1][0] = -prices[0];
        // dp[0][0][1] = 0;
        // dp[0][1][1] = -prices[0];
        // dp[0][0][2] = 0;
        // for(int i = 1; i < prices.length; i++) {
        //     dp[i][0][0] = 0;
        //     dp[i][1][0] = Math.max(dp[i-1][0][0] - prices[i], dp[i-1][1][0]); /// 0
        //     dp[i][0][1] = Math.max(dp[i-1][1][0] + prices[i], dp[i-1][0][1]); /// 1
        //     dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][1] - prices[i]); /// 2
        //     dp[i][0][2] = Math.max(dp[i-1][0][2], dp[i-1][1][1] + prices[i]); /// 3
        // }
        // return Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]);