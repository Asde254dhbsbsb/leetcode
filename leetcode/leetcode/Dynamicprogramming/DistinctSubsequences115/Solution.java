package Dynamicprogramming.DistinctSubsequences115;
// 115.不同的子序列
// 字符串s 和 t
/*通式：dp[i][j] = 0 (i < j) 
 *     dp[i][j] = dp[i-1][j-1] + dp[i-1][j] (s.charAt(i) == s.charAt(j))
 *     dp[i][j] = dp[i-1][j]                (s.charAt(i) != s.charAt(j))
*/
public class Solution {
    public int numDistinct(String s, String t) {
        
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for(int i = 1; i < m; i++) 
            if(s.charAt(i) == t.charAt(0)) dp[i][0] = dp[i-1][0] + 1;
            else dp[i][0] = dp[i-1][0];
        for(int j = 1; j < n; j++) {
            for(int i = 1; i < m; i++) {
                if(i >= j) {
                    if(s.charAt(i) == t.charAt(j)) dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("dp"+"["+i+"]"+"["+j+"]="+dp[i][j]);
            }
            System.out.println("");
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String s = "babgbag";
        String t = "bag";
        System.out.println("mn="+sl.numDistinct(s, t));
    }
}
