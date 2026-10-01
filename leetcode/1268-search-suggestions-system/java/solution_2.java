/**
 * Solution using a Trie
 * The difference between this one and solution_1, is that DFS was eliminated by caching top 3 words in each node.
 * In order to make it works, it's needed to sort the products before building the Trie.
 *
 * Runtime: 17ms
 * Memory: 49.19 MB
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        Trie trie = new Trie(products, 3);
        List<List<String>> ans = new ArrayList<>();

        var node = trie.root();
        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.getNode(c);
            }
            ans.add(node == null ? Collections.emptyList() : node.getTop());
        }

        return ans;
    }
}

class TrieNode {
    private TrieNode[] next;
    private List<String> top;
    private int max;

    public TrieNode(int max) {
        next = new TrieNode[26];
        top = new ArrayList<>(max);
        this.max = max;
    }

    public void putNode(char c, TrieNode node) {
        next[c - 'a'] = node;
    }

    public TrieNode getNode(char c) {
        return next[c - 'a'];
    }

    public List<String> getTop() {
        return top;
    }

    public void offer(String word) {
        if (top.size() < max) {
            top.add(word);
        }
    }
}

class Trie {

    private final TrieNode root;
    private int max;

    public Trie(String[] words, int max) {
        this.max = max;
        root = new TrieNode(max);
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
                    tmp = new TrieNode(max);
                    node.putNode(c, tmp);
                }
                node = tmp;
                node.offer(word);
            }
        }
    }
}