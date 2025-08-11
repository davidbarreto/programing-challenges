use std::collections::HashMap;

impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        let mut memo: HashMap<usize, bool> = HashMap::new();
        Solution::word_break_search(&s, 0, &word_dict, &mut memo)
    }

    fn word_break_search(s: &str, index: usize, word_dict: &Vec<String>, memo: &mut HashMap<usize,bool>) -> bool {
        if index == s.len() {
            return true;
        }

        if let Some(&cached) = memo.get(&index) {
            return cached;
        }

        for word in word_dict {
            if s[index..].starts_with(word) {
                if Solution::word_break_search(s, index + word.len(), word_dict, memo) {
                    return true;
                }
            }
        }

        memo.insert(index, false);
        false
    }
}