use std::array;

struct TrieNode {
    children: [Option<Box<TrieNode>>; 26],
    word: Option<String>,
    children_count: usize,
}

impl TrieNode {
    fn new() -> Self {
        TrieNode {
            children: array::from_fn(|_| None),
            word: None,
            children_count: 0,
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
            for byte in word.as_bytes() {
                let index = (byte - b'a') as usize;
                current = current.children[index].get_or_insert_with(|| {
                    current.children_count += 1;
                    Box::new(TrieNode::new())
                });
            }
            current.word = Some(word.clone());
        }

        // Iterate through the board and search for words
        let mut result = Vec::new();
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                Self::dfs(&mut board, i, j, &mut root, &mut result, words.len());
                if words.len() == result.len() {
                    return result;
                }
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

        // Cell already seen. Nothing to do here
        let ch = board[i][j];
        if ch == '#' {
            return;
        }

        // Char not found in current node. Nothing else to do
        let index: usize = (ch as u8 - b'a') as usize;
        if root.children[index].is_none() {
            return;
        }

        // Check if this char is the end of a word
        // If yes, store this result and clear this final word
        let next_node = root.children[index].as_mut().unwrap();
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
        if next_node.children_count == 0 && next_node.word.is_none() {
            root.children[index] = None;
            root.children_count -= 1;
        }
    }
}