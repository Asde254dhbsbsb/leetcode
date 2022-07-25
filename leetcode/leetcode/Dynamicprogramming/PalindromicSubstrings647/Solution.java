package PalindromicSubstrings647;

public class Solution {
    // 中心拓展 n个字符串，有n + n + 1 = 2*n - 1个中心
    public int centerExpand(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < 2*n-1; i++) {
            // 比较哪几个呢？ ---- 都是s.charAt(i/2)和s.charAt((i+1)/2);
            int l = i/2, r = (i+1)/2;
            while(l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            }
        }
        return count;
    }
    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        // boolean[][] dp = new boolean[n][2];
        boolean[] pre = new boolean[n];
        boolean[] tmp = new boolean[n];
        // dp[0][0] = true;
        pre[0] = true;
        count++;
        for(int i = 1; i < n; i++) {
            for(int k1 = 0; k1 <= i; k1++) {
                boolean flag = s.charAt(k1) == s.charAt(i);
                // dp[k1][i] = i - k1 > 1 ? (flag ? dp[k1+1][i-1] : false) : flag;
                tmp[k1] = i - k1  > 1 ? (flag ? pre[k1+1] : false) : flag;
                if(tmp[k1]) count++;
                // if(dp[k1][i]) count++;
            }
            pre = tmp;
        }
        return count;
    }


}
