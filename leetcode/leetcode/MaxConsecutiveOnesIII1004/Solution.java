package leetcode.MaxConsecutiveOnesIII1004;

public class Solution {
        // 使用前缀和数组
        //     for (int right = 0; right < n; ++right) {
        //     rsum += 1 - nums[right]; // 0变1 1变0 求前缀和 这样就可以知道前面有多少个0
        //     while (lsum < rsum - k) { // 只要0个数大于k个继续移动左边窗口
        //         lsum += 1 - nums[left];
        //         ++left;
        //     }
        //     ans = Math.max(ans, right - left + 1);
        // }

    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        int left=0,right=0;
        while(right < n){
            if(nums[right] == 1) ;
            else if(k > 0) { //为0但是还有k
                k--;
            } 
            else { //为0 k也为0
                while(nums[left++] == 1) ;
            }
            max = right - left + 1 > max ? right - left + 1: max;
            right++;
            
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(sl.longestOnes(nums, k));
    }
    
}
