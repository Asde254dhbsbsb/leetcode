package Dynamicprogramming.MinimumPathSum64;

public class Solution {
    public int minPathSum(int[][] grid) {
        System.out.println("data:"+grid[0][0]);
        int m = grid.length;
        int n = grid[0].length;
        int[][] minDis = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) minDis[0][0] = grid[0][0];
                else if(i == 0) minDis[0][j] = minDis[0][j] + grid[0][j];
                else if(j == 0) minDis[i][0] = minDis[i-1][0] + grid[i][0];
                else minDis[i][j] = Math.min(minDis[i-1][j], minDis[i][j-1]) + grid[i][j];
            }
        }
        return minDis[m-1][n-1];
    }
}
