package leetcode.Dynamicprogramming.SuperUglyNumber313;

import java.io.LineNumberInputStream;

import javax.swing.ImageIcon;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] p = new int[primes.length]; // 指针
        int[] dp = new int[primes.length]; // 丑数
        for(int i:p) i = 1;
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = getMin(primes, p);
        }

        return dp[n-1];
    }
    int getMin(int[] primes, int[] p) {
        int min = primes[0]*p[0];
        for(int i = 1; i < primes.length; i++) {
            if((num = primes[i]*p[i]) < min) min = num;         
        }
        for(int i = 0; i < primes.length; i++) 
            if(primes[i]*p[i] == min) p[i]++;
        return min;
    }
}
