package br.com.dbarreto.challenge.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.dbarreto.challenge.misc.util.TrieNode;

public class ReplaceCharacter {
	
	
	public List<String> replaceBruteForce(List<String> queryWords, List<String> dict) {
		return null;
	}

	public List<String> replace(List<String> queryWords, List<String> dict) {
	
		TrieNode root = buildTrie(dict);
		Set<Character> charSet = buildCharSet();
		List<Option> options = buildOptions(queryWords, root, charSet);
		if (options.isEmpty()) {
			return Collections.emptyList();
		}
		
		return null;
	}
	
	private List<Option> buildOptions(List<String> queryWords, TrieNode root, Set<Character> charSet) {
		
		List<Option> options = new ArrayList<>();
		for (String q : queryWords) {
			Option o = buildOption(q, root);
			
			if (o.candidates == null || o.candidates.isEmpty()) {
				return Collections.emptyList();
			} else if (o.candidates.size() == 1) {
				o.chosen = o.candidates.iterator().next();
				if (charSet.contains(o.chosen)) {
					charSet.remove(o.chosen);
				} else {
					return Collections.emptyList();
				}
			}
			
			options.add(o);
		}
		
		return options;
	}
	
	private void search(Option o, List<Option> options, List<String> solution, Set<Character> charSet) {
		
//		if (foundSolution(charSet)) {
//			solution.addAll(getCurrentSolution(options));
//			return;
//		}
//		
//		
//
//		for (Option o : options) {
//			
//		}
//		search(options, solution, charSet);
//		
		
	}
	
	private List<String> getCurrentSolution(List<Option> options) {
		
		List<String> ans = new ArrayList<>();
		for (Option op : options) {
			StringBuilder b = new StringBuilder(op.word);
			b.setCharAt(op.index, op.chosen);
			ans.add(b.toString());
		}
		
		return ans;
	}
	
	private boolean foundSolution(Set<Character> charSet) {
		return charSet.isEmpty();
	}
	
	private Set<Character> buildCharSet() {
		
		Set<Character> set = new HashSet<>();
		for (char c = 'a'; c <= 'z'; c++) {
			set.add(c);
		}
		
		return set;
	}
	
	private Option buildOption(String word, TrieNode root) {
		
		//Fill the char options that are possible to replace the '*'
		Option option = new Option(word);
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch == '*') {
				option.index = i;
				option.node = node;
				option.candidates = node.children.keySet();
				break;
			}
			if (node.children.containsKey(ch)) {
				node = node.children.get(ch);
			}
		}
		
		//Remove options that will end up in a different word
		for (Map.Entry<Character, TrieNode> entry : option.node.children.entrySet()) {
			TrieNode t = entry.getValue();
			for (int i = option.index + 1; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (t.children.containsKey(ch)) {
					t = t.children.get(ch);
				} else {
					option.candidates.remove(ch);
					break;
				}
			}
		}
		
		return option;
	}
	
	private void explore(TrieNode node, String sufix, Set<Character> options) {
		
		if (sufix.isEmpty()) {
			return;
		}
		
	}
	
	private TrieNode buildTrie(List<String> dict) {
		
		TrieNode root = new TrieNode();
		for (String word : dict) {
			buildTrie(word, root);
		}
		return root;
	}
	
	private void buildTrie(String word, TrieNode root) {
		
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (node.children.containsKey(ch)) {
				node = node.children.get(ch);
			} else {
				TrieNode trieNode = new TrieNode(ch);
				node.children.put(ch, trieNode);
				node = trieNode;
			}
		}
	}
	
	class Option {
		public String word;
		public Set<Character> candidates;
		public TrieNode node;
		public int index;
		public Character chosen;
		
		public Option(String word) {
			this.word = word;
		}
	}
}