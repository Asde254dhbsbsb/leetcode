package PerfectSquares279;

public class Solution {
    public int numSquares(int n) {
// 和为 n 的完全平方数的最小数量
        // int maxN = (int)Math.pow(n*1.0, 0.5);
        // List<Integer> nList = new ArrayList<>();
        // for(int i = 1; i <= maxN; i++) nList.add(i*i);
            
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for(int j = 1; j*j <= i; j++) {
                dp[i] = dp[i] > dp[i-j*j]+1? dp[i-j*j]+1 : dp[i]; 
            }
        }
        return dp[n];
    }
}
