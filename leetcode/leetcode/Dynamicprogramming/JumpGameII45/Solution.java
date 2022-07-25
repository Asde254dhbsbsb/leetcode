package Dynamicprogramming.JumpGameII45;

public class Solution {
    public int jump(int[] nums) {
        // 使用最少的跳跃次数
        // 一定可以到达
        // 找能到达dest最大的那个然后依次回推，但是最后一定是到0
        // 遍历找到最大能直接到达dest的
        if(nums.length == 1) return 0;
        int[] maxDest = new int[nums.length];
        int dest = nums.length - 1;
        int count = 0;
        for(int i = 0; i < nums.length; i++) 
            maxDest[i] = i + nums[i];
        while(dest != 0) {
            for(int i=0; i <= dest; i++) {
                if(maxDest[i] >= dest) {
                    dest = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    // 如何牺牲空间换时间？对每个dest
    public int jump1(int[] nums) {
        if(nums.length == 1) return 0;
        int maxPost = 0;
        int count = 0;
        int dest = 0;
        for(int i = 0; i < nums.length - 1;i++) {
            maxPost = Math.max(maxPost, i + nums[i]);
            if(i == dest) {
                dest = maxPost;
                count++;
                // 贪心?如果我们「贪心」地进行正向查找，每次找到可到达的最远位置
                // 在具体的实现中，我们维护当前能够到达的最大下标位置，记为边界。
                // 我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {100,3,0,1,4};
        System.out.println("jumpcount="+sl.jump(nums));
    }
}
