impl Solution {
    pub fn set_zeroes(matrix: &mut Vec<Vec<i32>>) {
        
        let mut has_zero_in_first_col = false;

        let m = matrix.len();
        let n = matrix[0].len();

        for i in 0..m {

            if matrix[i][0] == 0 {
                has_zero_in_first_col = true;
            }

            for j in 1..n {

                if matrix[i][j] == 0 {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for i in (0..m).rev() {
            for j in (1..n).rev() {
                if matrix[i][0] == 0 || matrix[0][j] == 0 {
                    matrix[i][j] = 0;
                }
            }

            if has_zero_in_first_col {
                matrix[i][0] = 0;
            }
        }
    }
}