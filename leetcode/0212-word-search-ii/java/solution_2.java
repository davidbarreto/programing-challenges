class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        Trie dict = new Trie(words);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(i, j, board, dict, dict.root, result, words.length);
            }
        }

        return result;
    }

    private void dfs(int i, int j, char[][] board, Trie dict, TrieNode root, List<String> result, int max) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (result.size() >= max) {
            return;
        }
        
        char ch = board[i][j];
        if (ch == '#') {
            return;
        }
        TrieNode node = root.children[ch - 'a'];
        if (node == null) {
            return;
        }
        
        if (node.isEndOfWord) {
            result.add(node.word);
            dict.remove(node.word);
        }

        board[i][j] = '#';

        dfs(i+1, j, board, dict, node, result, max);
        dfs(i-1, j, board, dict, node, result, max);
        dfs(i, j+1, board, dict, node, result, max);
        dfs(i, j-1, board, dict, node, result, max);

        board[i][j] = ch;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public Trie(String[] words) {
        this();
        for (String word : words) {
            add(word);
        }
    }

    public void add(String word) {

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
        current.word = word;
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private TrieNode remove(TrieNode root, String word, int index) {

        if (root == null) {
            return null;
        }

        if (index == word.length()) {
            root.isEndOfWord = false;
            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }

        int i = word.charAt(index) - 'a';
        root.children[i] = remove(root.children[i], word, index+1);

        if (isEmpty(root) && root.isEndOfWord == false) {
            root = null;
        }

        return root;
    }

    public boolean isEmpty() {
        return isEmpty(root);
    }

    private boolean isEmpty(TrieNode node) {

        if (node == null) {
            return true;
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }

        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}