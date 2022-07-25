package Dynamicprogramming.JumpGame55;

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        // 从最后一个下标依次回推
        int dest = nums.length - 1;
        boolean flag = true;
        for(int tmp = nums.length-2; tmp >= 0; tmp--) {
            if(nums[tmp] >= dest - tmp) {
                dest =tmp;
            } else if(tmp == 0)   //如果达不到而且，tmp为0那么就一定为false了；
                flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {2,3,1,1,4};
        System.out.println("flag="+sl.canJump(nums));
    }
}