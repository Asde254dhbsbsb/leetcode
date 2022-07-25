package JZoffer.jz03;

import java.util.Arrays;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i){//一直交换直到刚好在坑里面
                int tmp = nums[i];
                if(nums[tmp] == tmp) {
                    System.out.println(Arrays.toString(nums));
                    return tmp;
                }
                else {
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
        }
        return -1;
    }
}
