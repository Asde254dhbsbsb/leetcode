package ArrayPartitionI561;

public class Solution {
    public int arrayPairSum(int[] nums) {
        int[] po = new int[10001];
        int[] na = new int[10001];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) po[nums[i]] = 1 + po[nums[i]];
            else na[-nums[i]] = na[-nums[i]] + 1;
        }
        //  从na末尾遍历直到po末尾！
        int sum = 0;
        int a1 = 0, b1 = 0;
        for(int i = 10000; i > 0;) {
            while(i > 0 && na[i] == 0) i--;
            if(i > 0) {
                a1 = -i;
                na[i]--;
            } else a1 = 0;
            while(i > 0 && na[i] == 0) i--;
            if(i > 0) {
                b1 = -i;
                na[i]--;
            } else b1 = 0;
            if(a1 != 0 && b1 != 0) {
                sum += Math.min(a1, b1);
                System.out.println("a1="+a1+" b1="+b1);
                a1 = 0;
                b1 = 0;
            }
            
        }
        //  
        int i = 0;
        if(a1 != 0 && b1 == 0) {
            while(i < 10001 && po[i] == 0) i++;
            b1 = i;
            po[i]--;
            sum += Math.min(a1, b1);
            System.out.println("a1="+a1+" b1="+b1);
        }
        a1 = 0;b1 = 0;
        for(; i < 10001;) {
            while(i < 10001 && po[i] == 0) i++;
            if(i < 10001) {
                a1 = i;
                po[i]--;
            }
            while(i < 10001 && po[i] == 0) i++;
            if(i < 10001) {
                b1 = i;
                po[i]--;
            }
            sum += Math.min(a1, b1);
            a1 = 0;
            b1 = 0;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {-470, 66, -4835, -5623};
        System.out.println(sl.arrayPairSum(nums));
    }
}
