use std::collections::HashSet;

impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        
        let n = 9;

        let mut cols: Vec<HashSet<char>> = vec![HashSet::new(); n];
        let mut rows: Vec<HashSet<char>> = vec![HashSet::new(); n];
        let mut boxes: Vec<HashSet<char>> = vec![HashSet::new(); n];

        for (i, row) in board.iter().enumerate() {
            for (j, ch) in row.iter().enumerate() {

                if *ch == '.' {
                    continue;
                }

                //Validate row
                if rows[i].contains(ch) {
                    return false;
                }
                rows[i].insert(*ch);

                //Validate col
                if cols[j].contains(ch) {
                    return false;
                }
                cols[j].insert(*ch);

                //Validate sub-boxes
                let box_index = Self::calculate_box(i, j);
                if boxes[box_index].contains(ch) {
                    return false;
                }
                boxes[box_index].insert(*ch);
            }
        }

        return true;
    }

    fn calculate_box(i: usize, j: usize) -> usize {
        (i / 3) * 3 + (j / 3)
    }
}