package br.com.dbarreto.challenge.hackerrank.interview.kit.trie;

import java.util.ArrayList;
import java.util.List;

public class Contacts {

    private Contacts() {}

    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        var trie = new Trie();

        for (List<String> row : queries) {
            String op = row.get(0);
            String word = row.get(1);

            if ("add".equals(op)) {
                trie.add(word);
            } else {
                result.add(trie.countPrefixes(word));
            }
        }
        return result;
    }
}

class Trie {
    TrieNode root = new TrieNode();
    public void add(String name) {

        var node = root;
        for (int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            var child = node.getChild(c);
            if (child == null) {
                child = new TrieNode();
                node.addChild(c, child);
            }
            node = child;
            node.count++;
        }
        node.isWord = true;
    }

    public int countPrefixes(String prefix) {

        var node = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            var child = node.getChild(c);
            if (child == null) {
                return 0;
            }
            node = child;
        }

        return node.count;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
    int count;

    public TrieNode getChild(char c) {
        return children[c - 'a'];
    }

    public void addChild(char c, TrieNode child) {
        children[c - 'a'] = child;
    }
}
