package Greedy.BuyAndSellStockI121;

public class Solution {
    public int maxProfit(int[] prices) {
// 尽量选择股价格低的买入选择高的卖出！
        int preIndex = 0;    
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int maxIncome = dp[0];
        for(int i = 1; i < prices.length; i++) {
            int tmpInCome = prices[i] - prices[preIndex];
            if(tmpInCome > maxIncome) {
                maxIncome = tmpInCome;
            } else if(tmpInCome < 0) {
                preIndex = i;
            }    
        }

        return maxIncome;
    }

}
