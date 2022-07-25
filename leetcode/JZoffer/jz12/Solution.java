package JZoffer.jz12;

public class Solution {
    // 回溯！
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(backTarck(visited, board, word, i, j, 0)) return true;;
            }
        return false;
    }

    public boolean backTarck(boolean[][] visited, char[][] board, String word, int i, int j, int index) {
        if(i >= board.length || i < 0 || j < 0 || j >= board[0].length || 
            board[i][j] != word.charAt(index) || visited[i][j] == true) return false;
        if(index == word.length() - 1) return true;

        visited[i][j] = true;
        if(backTarck(visited, board, word, i+1, j, index+1)) return true;
        if(backTarck(visited, board, word, i, j+1, index+1)) return true;
        if(backTarck(visited, board, word, i-1, j, index+1)) return true;
        if(backTarck(visited, board, word, i, j-1, index+1)) return true;
        visited[i][j] = false;
        return false;
    }
}
