use std::collections::HashSet;

impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        
        let mut seen = HashSet::with_capacity(nums.len());
        for num in nums {
            seen.insert(num);
        }

        let mut longest = 0;
        for num in seen.iter() {
            if seen.contains(&(num-1)) {
                continue;
            }

            let mut sequence_size = 1;
            while seen.contains(&(num + sequence_size)) {
                sequence_size += 1;
            }

            longest = longest.max(sequence_size);
        }
        longest
    }
}