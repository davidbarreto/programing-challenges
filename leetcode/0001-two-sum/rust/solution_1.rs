use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut pairs: HashMap<i32, i32> = HashMap::new();

        for (i, num) in nums.iter().enumerate() {
            if let Some(val) = pairs.get(&(target - num)) {
                return vec![*val, i as i32];
            }
            pairs.insert(*num, i as i32);
        }

        vec![]
    }
}