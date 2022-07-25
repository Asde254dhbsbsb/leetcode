package Dynamicprogramming.BestTimetoBuyandSellStockII122;
    // 贪心 : 一次遍历 只要今天的股票比明天的价格低就今天买入明天卖出！
    // 我觉得是因为如果一直持有着不太行？ 贪心？
public class GreedySolution {
    // 由于股票的购买没有限制，因此整个问题等价于寻找 xx 个不相交的区间
    // 在a天买入在b天卖出，有多个这样的区间使得求和最大
    // [a,b]等价于在[a, a+1]...[b-1, b]这么多长度为1的区间，选择正值即可使得价值最大化

    public int maxProfit(int[] prices) {
        int tmpPrice = prices[0];
        int totalInCome = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > tmpPrice) 
                totalInCome += prices[i] - tmpPrice;
            tmpPrice = prices[i];
        }
        return totalInCome;
    }
}
