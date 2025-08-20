package br.com.dbarreto.challenge.misc.util;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	public Character val;
	public Map<Character, TrieNode> children;
	public boolean isWord = false;
	
	public TrieNode(Character c) {
		val = c;
		children = new HashMap<>();
	}
	
	public TrieNode() {
		this(null);
	}
}
