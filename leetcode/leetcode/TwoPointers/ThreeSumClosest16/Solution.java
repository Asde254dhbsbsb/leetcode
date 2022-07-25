package ThreeSumClosest16;

import java.util.Arrays;

public class Solution {
    /**
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int minGap = Integer.MAX_VALUE;
        int closetSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            if(i > 0 && a == nums[i-1] ) continue;
            int p1 = i + 1,p2 = n - 1;

            /* while(p1 < p2) {
                int gap = a + nums[p1] + nums[p2] - target;
                while(p2 > p1 && gap > 0) {
                    if(minGap > gap) {
                        minGap = gap;
                        closetSum = a + nums[p1] + nums[p2];
                    }
                    p2--;
                    while(nums[p2] == nums[p2+1] && p2 > p1) p2--; // 确保不一样！！！
                    gap = a + nums[p1] + nums[p2] - target;
                }
                
                while(p2 > p1 && gap < 0) {
                    if(minGap > - gap) {
                        minGap = - gap;
                        closetSum = a + nums[p1] + nums[p2] ;
                    }
                    p1++;
                    while(nums[p1] == nums[p1-1] && p1 < p2) p1++;
                    gap = a + nums[p1] + nums[p2] - target;
                }

            } */
            // 上面这个内外循环可以结合在一起，完全是多余的！！！
            while(p1 < p2) {
                int gap = a + nums[p1] + nums[p2] - target;
                if(gap == 0) return target;
                if(Math.abs(gap) < minGap) {
                    minGap = Math.abs(gap);
                    closetSum = a + nums[p1] + nums[p2];
                }
                // 每一次只移动一次指针，和三位数为0那个不一样；
                if(gap > 0) {
                    p2--;
                    while( p2 > p1 && nums[p2] == nums[p2+1]) p2--; // 确保不一样！！！
                } else {
                    p1++;
                    while( p1 < p2 && nums[p1] == nums[p1-1]) p1++;// 确保不一样！！！
                }

            }
        }

        return closetSum;

    }

    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        // -5 -5 -4 0 0 3 3 4 5；
        int target = -2;
        Solution sl = new Solution();
        System.out.println(sl.threeSumClosest(nums, target));;
    }
}
