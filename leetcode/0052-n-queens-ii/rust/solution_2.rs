impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        let n = n as usize;
        let mut cols = vec![false; n];
        let mut diag1 = vec![false; 2 * n - 1]; // row - col + n - 1
        let mut diag2 = vec![false; 2 * n - 1]; // row + col
        Self::backtrack(0, n, &mut cols, &mut diag1, &mut diag2)
    }

    fn backtrack(row: usize, n: usize, cols: &mut Vec<bool>, diag1: &mut Vec<bool>, diag2: &mut Vec<bool>) -> i32 {
        if row == n {
            return 1;
        }

        let mut count = 0;
        for col in 0..n {
            let d1 = row as isize - col as isize + n as isize - 1;
            let d2 = row + col;
            if cols[col] || diag1[d1 as usize] || diag2[d2] {
                continue;
            }

            cols[col] = true;
            diag1[d1 as usize] = true;
            diag2[d2] = true;

            count += Self::backtrack(row + 1, n, cols, diag1, diag2);

            cols[col] = false;
            diag1[d1 as usize] = false;
            diag2[d2] = false;
        }

        count
    }
}