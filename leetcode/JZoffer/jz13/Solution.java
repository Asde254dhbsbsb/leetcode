package JZoffer.jz13;

public class Solution {
    public int movingCount(int m, int n, int k) {
        // 左右上下移动
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, k, 0, 0, 0);
    }

    public int dfs(boolean[][] visited, int m, int n, int k, int count, int i, int j) {
        if(visited[i][j] || i > m -1 || i < 0 || j > n - 1 || j < 0 || sum(i, j) > k) 
            return count;
        visited[i][j] = true;
        count++;
        count = dfs(visited, m, n, k, count, i, j + 1);
        count = dfs(visited, m, n, k, count, i - 1, j);
        count = dfs(visited, m, n, k, count, i + 1, j);
        count = dfs(visited, m, n, k, count, i, j - 1);
        return count;
    }

    public int sum(int i, int j) {
        int total = 0;
        while(i + j != 0) {
            total += i%10 + j%10;
            i %= 10;
            j %= 10;
        }
        return total;
    }
}
