use std::collections::HashMap;

impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {

        let mut result: Vec<Vec<String>> = Vec::new();
        let mut map: HashMap<Vec<i32>, Vec<String>> = HashMap::new();
        for word in strs {

            let mut freq: Vec<i32> = vec![0; 26];
            for c in word.chars() {
                let index = c as usize - 'a' as usize;
                freq[index] += 1;
            }

            map.entry(freq).or_insert(Vec::new()).push(word);
        }

        map.into_values().collect()
    }
}