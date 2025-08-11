use std::collections::HashMap;

impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        let mut memo: HashMap<u8, bool> = HashMap::new();
        Solution::word_break_search(&s, 0, &word_dict, &mut memo)
    }

    fn word_break_search(s: &String, index: u8, word_dict: &Vec<String>, memo: &mut HashMap<u8,bool>) -> bool {
        if index == s.len() as u8 {
            return true;
        }

        if memo.contains_key(&index) {
            return memo.get(&index).unwrap().clone();
        }

        let mut res = false;
        for word in word_dict {
            if Solution::starts_with_at(s.as_str(), &word, index as usize) {
                res |= Solution::word_break_search(s, index + word.len() as u8, word_dict, memo);
            }
        }

        memo.insert(index, res);
        return res;
    }

    fn starts_with_at(s: &str, prefix: &str, offset: usize) -> bool {
        if offset > s.len() {
            return false;
        }
        s[offset..].starts_with(prefix)
    }
}