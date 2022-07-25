package leetcode.MinimumSizeSubarraySum209;

import java.util.Arrays;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int pre = 0,tmp = 0, total = 0;
        for (; pre < nums.length; pre++) {
            while(total < target){
                if(tmp == nums.length) return min == Integer.MAX_VALUE ? 0 : min;
                total += nums[tmp];
                tmp++;
            }
            min = min < tmp - pre ? min : tmp - pre;
            int i = Arrays.binarySearch(nums, 11);
            total -= nums[pre];
        }
        //前缀和+二分查找
        // for (int i = 1; i <= n; i++) {
        //     sums[i] = sums[i - 1] + nums[i - 1];
        // }
        // for (int i = 1; i <= n; i++) {
        //     int target = s + sums[i - 1];
        //     int bound = Arrays.binarySearch(sums, target);
        //     if (bound < 0) {
        //         bound = -bound - 1;
        //     }
        //     if (bound <= n) {
        //         ans = Math.min(ans, bound - (i - 1));
        //     }
        // }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static void main(String[] args) {
        // 11
// [1,2,3,4,5]
        Solution sl = new Solution();
        int target = 11;
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(sl.minSubArrayLen(target, nums));
    }
}
