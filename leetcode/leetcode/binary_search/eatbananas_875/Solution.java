package leetcode.binary_search.eatbananas_875;

import javax.swing.text.PlainDocument;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 通过max min来求
        int max = 0, min = 0;
        for(int data : piles) 
            if(data > max) max = data;
        int minK = max;
        while(min <= max) {
            int mid = (max - min)/2 + min;
            if(judge(piles, h, mid)) {
                minK = mid < minK ? mid : minK;
                max = mid - 1;
            } else 
                min = mid + 1;
        }
        return h;
    }

    boolean judge(int[] piles, int h, int k) {
        int index = 0;
        while(index < piles.length) {
            int count = (piles[index] % k == 0) ? piles[index]/k : piles[index]/k + 1;
            k -= count;
            if(k < 0) return false;
            index++;
        }
        return k >= 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(s.minEatingSpeed(piles, h));
    }
}
