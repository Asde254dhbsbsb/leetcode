package TargetSum494;
//     给你一个整数数组 nums 和一个整数 target 。
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 设负号的元素和为  fuhsu 
        // 那么有sum + (-fushu) - sushu = target
        // 那么有  fushu = （sum - target）/2 -- 等价于sum - target必须是偶数，然后再nums里找几个数和为fushu
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}
