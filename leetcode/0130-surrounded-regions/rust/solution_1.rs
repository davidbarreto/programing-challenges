impl Solution {
    pub fn solve(board: &mut Vec<Vec<char>>) {
        
        let m = board.len();
        let n = board[0].len();

        for i in 0..m {
            Self::dfs(board, i, 0);
            Self::dfs(board, i, n-1);
        }

        for j in 0..n {
            Self::dfs(board, 0, j);
            Self::dfs(board, m-1, j);
        }

        for i in 0..m {
            for j in 0..n {
                if board[i][j] == '#' {
                    board[i][j] = 'O';
                } else if board[i][j] == 'O' {
                    board[i][j] = 'X';
                }
            }
        }
    }

    fn dfs(board: &mut Vec<Vec<char>>, i: usize, j: usize) {

        if i < 0 || j < 0 || i >= board.len() || j >= board[0].len() || board[i][j] != 'O' {
            return;
        }

        board[i][j] = '#';

        Self::dfs(board, i+1, j);
        Self::dfs(board, i-1, j);
        Self::dfs(board, i, j+1);
        Self::dfs(board, i, j-1);
    }
}