impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {

        if n == 1 {
            return 1;
        }

        let size = n as usize;
        let mut matrix: Vec<Vec<u8>> = vec![vec![0; size]; size];
        Solution::search(&mut matrix, 0 as usize, size)
    }

    fn search(matrix: &mut Vec<Vec<u8>>, row: usize, size: usize) -> i32 {

        //println!("Searching row: {}", row);

        if row == size {
            println!("Reached the end of rows, returning 1");
            return 1;
        }

        let mut total = 0;
        for col in 0..size {

            //println!("Searching column: {}", col);
            matrix[row][col] = 1;
            if !Solution::has_attack(row, col, &matrix, size) {
                print!("Placing queen at ({}, {})\n", row, col);
                total += Solution::search(matrix, row+1, size);
            }
            matrix[row][col] = 0;
            println!("Resetting [{},{}] to 0", row, col);
        }
        total
    }

    fn has_attack(row: usize, col: usize, matrix: &Vec<Vec<u8>>, size: usize) -> bool {

        //println!("Checking attacks for position ({}, {})", row, col);

        if Solution::has_attack_column(matrix, col, size)
            || Solution::has_attack_diagonal(matrix, row, col, size, (1, 1))
            || Solution::has_attack_diagonal(matrix, row, col, size, (1, -1))
            || Solution::has_attack_diagonal(matrix, row, col, size, (-1, 1))
            || Solution::has_attack_diagonal(matrix, row, col, size, (-1, -1)) {
            return true;
        }

        //print!("All checks passed for position ({}, {}), no attacks detected.\n", row, col);
        false
    }

    fn has_attack_column(matrix: &Vec<Vec<u8>>, col: usize, size: usize) -> bool {
        let mut count = 0;
        for r in 0..size {
            count += matrix[r][col];
            if count > 1 {
                //println!("Attack detected on column: {}", col);
                return true;
            }
        }
        false
    }

    fn has_attack_diagonal(matrix: &Vec<Vec<u8>>, row: usize, col: usize, size: usize, direction: (i32, i32)) -> bool {

        let mut count = 0;
        let mut r = row as i32;
        let mut c = col as i32;
        while r >= 0 && r < size as i32 && c >= 0 && c < size as i32 {
            count += matrix[r as usize][c as usize];
            if count > 1 {
                return true;
            }
            
            r += direction.0;
            c += direction.1;
        }
        false
    }
}