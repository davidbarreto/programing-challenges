use std::cmp;

impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        
        let len = nums.len();

        if len == 1 {
            return nums[0];
        }

        let mut dp: Vec<i32> = vec![0; len];
        dp[0] = nums[0];
        dp[1] = cmp::max(nums[0], nums[1]);

        for i in 2..len {
            dp[i] = cmp::max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[len-1];
    }
}