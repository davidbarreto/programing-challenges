/**
 * Solution using a Trie
 * 1. The trie uses a regular array as children nodes, since for lowercase chars we have only 26 possibilities and
 * keys are sorted for free (previously I tried with a TreeMap, which works but using the Red-Black tree implementation
 * looked too much). Also, there is a String as terminal word, so I don't have to "build" the word character per character
 * during search.
 * 2. There is a DFS in the Trie nodes, starting from the next node after the one which matches the prefix "searchWord"
 *
 * Runtime: 76ms
 * Memory: 48.19 MB
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie trie = new Trie(products);
        List<List<String>> ans = new ArrayList<>();

        var node = trie.root();
        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.getNode(c);
            }
            ans.add(node == null ? Collections.emptyList() : trie.collect(node, 3));
        }

        return ans;
    }
}

class TrieNode {
    TrieNode[] next;
    String word;

    public TrieNode() {
        next = new TrieNode[26];
        word = null;
    }

    public void putNode(char c, TrieNode node) {
        next[c - 'a'] = node;
    }

    public TrieNode getNode(char c) {
        return next[c - 'a'];
    }

    public String getWord() {
        return word;
    }

    public void endWord(String s) {
        word = s;
    }
}

class Trie {

    private final TrieNode root;

    public Trie(String[] words) {
        root = new TrieNode();
        build(words);
    }

    public TrieNode root() {
        return root;
    }

    public void build(String[] dictionary){

        for (String word : dictionary) {
            var node = root;
            for (char c : word.toCharArray()) {
                var tmp = node.getNode(c);
                if (tmp == null) {
                    tmp = new TrieNode();
                    node.putNode(c, tmp);
                }
                node = tmp;
            }
            node.endWord(word);
        }
    }

    public List<String> collect(TrieNode node, int max) {
        List<String> words = new ArrayList<>();
        search(node, words, max);
        return words;
    }

    public void search(TrieNode node, List<String> words, int max) {
        if (node == null || words.size() == max) {
            return;
        }

        var word = node.getWord();
        if (word != null) {
            words.add(word);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (words.size() >= max) {
                break;
            }
            var n = node.getNode(c);
            if (n != null) {
                search(n, words, max);
            }
        }
    }
}