class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {        
                if (board[i][j] == word.charAt(0) && dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int count) {
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (word.charAt(count) != board[i][j]) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (count == word.length() -1) {
            return true;
        }

        boolean ans = dfs(board, word, visited, i, j+1, count+1) ||
            dfs(board, word, visited, i, j-1, count+1) ||
            dfs(board, word, visited, i+1, j, count+1) ||
            dfs(board, word, visited, i-1, j, count+1);
        
        visited[i][j] = false;
        return ans;
    }
}