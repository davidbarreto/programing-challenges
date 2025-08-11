use std::collections::HashMap;

impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        let n = s.len();
        let mut dp = vec![false; n + 1];
        dp[0] = true; // Empty prefix is always valid

        for i in 0..n {
            if !dp[i] {
                continue;
            }

            for word in &word_dict {
                let end = i + word.len();
                if end <= n && &s[i..end] == *word {
                    dp[end] = true;
                }
            }
        }

        dp[n]
    }
}