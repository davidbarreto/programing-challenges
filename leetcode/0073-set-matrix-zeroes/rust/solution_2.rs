impl Solution {
    pub fn set_zeroes(matrix: &mut Vec<Vec<i32>>) {
        
        let m = matrix.len();
        let n = matrix[0].len();

        let mut zero_rows: Vec<bool> = vec![false; m];
        let mut zero_cols: Vec<bool> = vec![false; n];

        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if matrix[i][j] == 0 {
                    zero_rows[i] = true;
                    zero_cols[j] = true;
                }
            }
        }

        for i in 0..m {
            if zero_rows[i] {
                Self::zero_row(matrix, i, n);
            }
        }

        for j in 0..n {
            if zero_cols[j] {
                Self::zero_col(matrix, j, m);
            }
        }
    }

    fn zero_row(matrix: &mut Vec<Vec<i32>>, row: usize, total_cols: usize) {

        for j in 0..total_cols {
            matrix[row][j] = 0;
        }

    }

    fn zero_col(matrix: &mut Vec<Vec<i32>>, col: usize, total_rows: usize) {
        
        for i in 0..total_rows {
            matrix[i][col] = 0;
        }
    }
}