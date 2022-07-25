package ThreeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return new ArrayList<>();
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n - 2; i++) {
            int a = nums[i];
            if(a > 0) break;
            if(i == 0 || a > nums[i-1]){ // i = 0 的时候可以直接进去                
                for(int p1 = i + 1, p2 = n - 1; p1 < n - 1; p1++) {
                    if(p1 > i + 1 && nums[p1] == nums[p1-1] ) continue; // p1 = i + 1 的时候以及不相等的时候可以直接进去

                    while(nums[p2] + nums[p2] > -a && p2 > p1) p2--; // p1不动，在里面让p2在while循环里面动， p1 p2是不断靠拢的
                    // while(nums[p1] + nums[p2] > -a && p2 > p1) p1++; // 这一行加了速度更低
                    if(p1 == p2) break; // 如果指针重合，后面随着b的增加也不会有匹配的了直接跳出循环

                    if(nums[p1] + nums[p2] == -a ) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(nums[p1]);
                        list.add(nums[p2]);
                        result.add(list); 
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {
            -1,0,1,2,-1,-4};
        sl.threeSum(nums);
    }
}
