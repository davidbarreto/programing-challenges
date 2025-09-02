class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        Trie dict = new Trie(words);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(new Coord(i, j), board, new ArrayDeque<>(), new HashSet<>(), dict, result, words.length);
            }
        }

        return result;
    }

    private void dfs(Coord coord, char[][] board, Deque<Character> currentWord, Set<Coord> seen, Trie dict, List<String> result, int max) {
        
        if (result.size() >= max) {
            return;
        }
        seen.add(coord);
        currentWord.addLast(board[coord.x()][coord.y()]);
        //System.out.println("Checking string: " + toString(currentWord));

        TrieNode node = dict.getLastNodeFrom(currentWord);
        if (node != null) {
            if (node.isEndOfWord) {
                String current = toString(currentWord);
                result.add(current);
                dict.remove(current);
            }
        } else {
            //System.out.println(toString(currentWord) + " is not a sufix in this dict!");
            currentWord.removeLast();
            seen.remove(coord);
            return;
        }

        for (Coord neighbor : getNeighbors(coord, board.length, board[0].length)) {
            if (!seen.contains(neighbor)) {
                dfs(neighbor, board, currentWord, seen, dict, result, max);
            }
        }
        currentWord.removeLast();
        seen.remove(coord);
    }

    private List<Coord> getNeighbors(Coord coord, int m, int n) {
        List<Coord> coords = new ArrayList<>();
        int i = coord.x();
        int j = coord.y();
        addCoordIfExists(i+1, j, m, n, coords);
        addCoordIfExists(i-1, j, m, n, coords);
        addCoordIfExists(i, j+1, m, n, coords);
        addCoordIfExists(i, j-1, m, n, coords);

        //System.out.println("m = " + m + ", n = " + n + ". Neighbors from " + coord + ": " + coords);
        return coords;
    }

    private void addCoordIfExists(int i, int j, int m, int n, List<Coord> coords) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            coords.add(new Coord(i, j));
        }
    }

    private String toString(Deque<Character> chars) {
        StringBuilder builder = new StringBuilder(chars.size());
        for (char ch : chars) {
            builder.append(ch);
        }

        return builder.toString();
    }
}

record Coord(int x, int y) {}

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

    public boolean contains(Deque<Character> word) {
        TrieNode current = root;
        for (char ch : word) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public TrieNode getLastNodeFrom(Deque<Character> word) {
        TrieNode current = root;
        for (char ch : word) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}