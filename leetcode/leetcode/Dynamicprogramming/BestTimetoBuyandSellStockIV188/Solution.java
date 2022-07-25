package BestTimetoBuyandSellStockIV188;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n==0) return 0;
        int[][] dp = new int[n][2*k];
        for(int i = 0; i < 2*k; i++) {            
            if(i%2 == 0) dp[0][i] = -prices[0];
            else dp[0][i] = 0;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 2*k; j++) {
                if(j%2 == 0) {
                    // 表示持有股票的 且已经交易了几次? (j+1)/2次
                    dp[i][j] = Math.max((j==0 ? 0:dp[i-1][j-1]) - prices[i], dp[i-1][j]);
                } else {
                    // 未持有股票 且已经交易了(j+1)/2次
                    dp[i][j] = Math.max(dp[i-1][j-1] + prices[i], dp[i-1][j]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < k; i++) {
            max = dp[n-1][i*2+1] > max ? dp[n-1][i*2+1] : max;
        }
        return max;
      }
}
