package jz10;

public class Solution {
// F(0) = 0,   F(1) = 1
// F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    public int fib(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        return dp[n];
    }

}
