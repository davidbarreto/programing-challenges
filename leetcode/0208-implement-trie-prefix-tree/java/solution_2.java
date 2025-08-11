class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            current = current.children.computeIfAbsent(ch, t -> new TrieNode());
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return search(word, true);
    }

    private boolean search(String word, boolean isEntireWord) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!current.children.containsKey(ch)) {
                return false;
            } else {
                current = current.children.get(ch);
            }
        }

        return isEntireWord ? current.isEndOfWord : true;
    }
    
    public boolean startsWith(String prefix) {
        return search(prefix, false);
    }

    
}

class TrieNode {

    public Map<Character, TrieNode> children;
    public boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */