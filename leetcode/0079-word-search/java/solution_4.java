class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, new HashSet<>(), i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, Set<List<Integer>> seen, int i, int j, int count) {
        
        if (count == word.length()) {
            return true;
        }

        List<Integer> key = Arrays.asList(i,j);

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
            word.charAt(count) != board[i][j] || seen.contains(key) ) {
            return false;
        }

        seen.add(key);
        boolean ans = dfs(board, word, seen, i, j+1, count+1) ||
            dfs(board, word, seen, i, j-1, count+1) ||
            dfs(board, word, seen, i+1, j, count+1) ||
            dfs(board, word, seen, i-1, j, count+1);
        seen.remove(key);
        return ans;
    }
}