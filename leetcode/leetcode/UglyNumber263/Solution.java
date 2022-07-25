package leetcode.UglyNumber263;

public class Solution {
    public boolean isUgly(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        int[] positive = {2, 3, 5};
        for(int i = 0; i < 3;i++) {
            while(n % positive[i] == 0) {
                n /= positive[i];
            }
        }
        if(n != 1) return false;
        return true;
    }
}
