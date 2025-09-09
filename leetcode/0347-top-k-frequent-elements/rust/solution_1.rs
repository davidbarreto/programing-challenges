use std::collections::HashMap;

impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {

        let mut freq: HashMap<i32, i32> = HashMap::new();
        for n in nums {
            freq.entry(n).and_modify(|c| *c += 1).or_insert(1);
        }

        let mut freq_vec: Vec<(i32, i32)> = freq.into_iter().collect();
        freq_vec.sort_by(|a, b| b.1.cmp(&a.1));
        return freq_vec.into_iter().take(k as usize).map(|(n, _)| n ).collect();
    }
}