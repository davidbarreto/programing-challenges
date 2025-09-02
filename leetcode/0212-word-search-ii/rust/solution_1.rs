use std::collections::HashMap;

struct TrieNode {
    word: Option<String>,
    children: HashMap<char, TrieNode>,
}

impl TrieNode {
    fn new() -> Self {
        TrieNode {
            word: None,
            children: HashMap::new(),
        }
    }
}

impl Solution {
    pub fn find_words(board: Vec<Vec<char>>, words: Vec<String>) -> Vec<String> {
        
        let mut board = board;
        let mut root = TrieNode::new();

        // Add all words to the Trie
        for word in &words {
            let mut current = &mut root;
            for ch in word.chars() {
                current = current.children.entry(ch).or_insert(TrieNode::new());
            }
            current.word = Some(word.clone());
        }

        // Iterate through the board and search for words
        let mut result = Vec::new();
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                Self::dfs(&mut board, i, j, &mut root, &mut result, words.len());
            }
        }

        result
    }

    fn dfs (board: &mut Vec<Vec<char>>, i: usize, j: usize, root: &mut TrieNode, result: &mut Vec<String>, total_words: usize) {

        // Already found all words, will not search anymore
        if result.len() == total_words {
            return;
        }

        // Invalid i or j
        if i >= board.len() || j >= board[0].len() {
            return;
        }

        // Cell already seen or char not found in current node.
        // Nothing to do here
        let ch = board[i][j];
        if ch == '#' || !root.children.contains_key(&ch) {
            return;
        }

        // Check if this char is the end of a word
        // If yes, store this result and clear this final word
        let next_node = root.children.get_mut(&ch).unwrap();
        if let Some(word) = &next_node.word {
            result.push(word.clone());
            next_node.word = None; // Avoid duplicates
        }

        // Mark the cell as visited
        board[i][j] = '#';

        // Explore neighbors
        if i + 1 < board.len() {
            Self::dfs(board, i + 1, j, next_node, result, total_words);
        }
        if i > 0 {
            Self::dfs(board, i - 1, j, next_node, result, total_words);
        }
        if j + 1 < board[0].len() {
            Self::dfs(board, i, j + 1, next_node, result, total_words);
        }
        if j > 0 {
            Self::dfs(board, i, j - 1, next_node, result, total_words);
        }

        // Restore the cell
        board[i][j] = ch;

        // Prune the Trie
        if next_node.children.is_empty() && next_node.word.is_none() {
            root.children.remove(&ch);
        }
    }
}