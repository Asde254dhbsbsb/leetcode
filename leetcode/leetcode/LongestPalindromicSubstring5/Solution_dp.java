package leetcode.LongestPalindromicSubstring5;

//使用动态规划
public class Solution_dp {
    public static void main(String[] args) {
        Solution_dp sl = new Solution_dp();
        String s = "aaaabacb";
        System.out.println(sl.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        int max = 0, n = s.length();
        String maxs = "";
        boolean[][] dp = new boolean[n][n];
        // 循环如何开始是很需要注意思考的
        // 从j到i 两层循环 j<=i 于是dp[j][i] = flag && dp[j + 1][i - 1]才能得到dp[j + 1][i - 1]
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                // j到i是否是回文串？
                boolean flag = s.charAt(i) == s.charAt(j);
                if(i - j <= 2) dp[j][i] = flag;
                // 只有i - j > 2时候才需要dp[j + 1][i - 1] 此时 j+1 < i-1这时候一定是有的因为在上一次循环i-1已经遍历过了
                else  dp[j][i] = flag && dp[j + 1][i - 1];
                if(dp[j][i] && i - j + 1 > max) {
                    maxs = s.substring(j, i+1);
                    max = i + 1 - j;
                }
            }
        }
        return maxs;
    }
}
