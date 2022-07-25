package Greedy.ContainerWithMostWater11;
// 让指针所指高较小的指针移动，这样就能保留高较大的边
// 保留较高的边！！！！！
public class Solution {
    public int maxArea(int[] height) {
        int left=0, right = height.length-1;
        int p1 = left, p2 = right;
        int maxWeight = Math.min(height[p1], height[p2]) * (p2 - p1), tmpWeight=0;

        while (p1 < p2) {
            if(height[p1] < height[p2]) {
                p1++;
                tmpWeight = Math.min(height[p1], height[p2]) * (p2 - p1);
                if(tmpWeight > maxWeight) {
                    maxWeight = tmpWeight;
                    left = p1;
                    right = p2;
                }
            } else {
                p2--;
                tmpWeight = Math.min(height[p1], height[p2]) * (p2 - p1);
                if(tmpWeight > maxWeight) {
                    maxWeight = tmpWeight;
                    left = p1;
                    right = p2;
                }
            }
        } 
        return maxWeight;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] height = {2,3,100,500,7,8,9};
        System.out.println(sl.maxArea(height));
    }
}
