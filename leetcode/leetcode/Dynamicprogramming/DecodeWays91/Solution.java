package Dynamicprogramming.DecodeWays91;

public class Solution {
    // dp[i] = dp[i - 1] + dp[i - 2]; (i-1和i可以匹配的话)
    public int numDecodings(String s) {
        // 10
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;

        if(s.length() == 1) return dp[0];
        dp[1] = (s.charAt(1) == '0' ? 0 : dp[0]) + (judge(s.charAt(0) - '0', s.charAt(1) - '0') ? 1 : 0);

        for(int i = 2; i < s.length(); i++) {
            dp[i] = (s.charAt(i) == '0' ? 0 : dp[i - 1]) + (judge(s.charAt(i - 1) - '0', s.charAt(i) - '0') ? dp[i - 2] : 0);
        }
        return dp[s.length() - 1];
    }

    boolean judge(int i, int i1) {
        System.out.println("i:" + i + "i1" + i1);
        int sum = i*10 + i1;
        if(sum > 9 && sum < 27) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String s = "10";
        System.out.println(sl.numDecodings(s));
    }
}

