impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        Self::solve(0, 0, 0, 0, n as usize)
    }

    fn solve(row: usize, cols: u32, diag1: u32, diag2: u32, n: usize) -> i32 {
        if row == n {
            return 1;
        }

        let mut count = 0;
        let available = !(cols | diag1 | diag2) & ((1 << n) - 1); // posiÃ§Ãµes livres

        let mut positions = available;
        while positions != 0 {
            let pos = positions & (!positions + 1); // bit mais Ã  direita
            positions ^= pos; // desmarca esse bit

            count += Self::solve(
                row + 1,
                cols | pos,
                (diag1 | pos) << 1,
                (diag2 | pos) >> 1,
                n,
            );
        }

        count
    }
}