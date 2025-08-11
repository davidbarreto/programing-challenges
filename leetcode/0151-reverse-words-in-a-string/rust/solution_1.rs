impl Solution {
    pub fn reverse_words(s: String) -> String {
        
        let original: Vec<char> = s.chars().collect();
        let mut ans: Vec<char> = vec!['\0'; s.len()];

        let len = Solution::reverse_recursion(&original, &mut ans, 0);
        return ans[0..len].iter().collect();
    }

    fn reverse_recursion(original: &Vec<char>, ans: &mut Vec<char>, mut start: usize) -> usize {

        while start < original.len() && original[start] == ' ' {
            start += 1;
        }

        let mut end = start;
        while end < original.len() && original[end] != ' ' {
            end += 1;
        }

        if start == end {
            return 0;
        }

        let mut len = Solution::reverse_recursion(original, ans, end);
        if len != 0 {
            ans[len] = ' ';
            len += 1;
        }

        while start < end {
            ans[len] = original[start];
            len += 1;
            start += 1;
        }

        return len;
    }
}