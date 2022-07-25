package JZoffer.jz04;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        
        // 每一行二分
        // 可以使用Z字查找 每一次只需要比较一次
        // 比如（x,y）
        // ==target return
        // > target 则可以将该列的数全部排除，y--
        // < target 则可以将该行的数全部排除，x++
        int n = matrix.length;      //n行
        if(n == 0) return false;
        int m = matrix[0].length;   //m列
        if(m == 0) return false;
        
        int x = 0, y = m - 1;
        while(true){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] > target) y--;
            else x++;
            if(y < 0 || x >= n) return false;
        }
    }
}
