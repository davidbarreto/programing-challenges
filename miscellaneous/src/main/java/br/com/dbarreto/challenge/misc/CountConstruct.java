package br.com.dbarreto.challenge.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Return the number of ways that 'target' can be constructed
 * by concatenating elements of the 'wordBank' array.
 * You may reuse elements of 'wordBank' as many times as needed 
 */
public class CountConstruct {

	public int solveByRecursion(String target, List<String> wordBank) {
		return solveByRecursion(target, wordBank, new HashMap<>());
	}

	private int solveByRecursion(String target, List<String> wordBank, Map<String, Integer> memo) {
		
		if (memo.containsKey(target)) {
			return memo.get(target);
		}
		
		if (target.isEmpty()) {
			return 1;
		}
		
		int count = 0;
		for (String word : wordBank) {
			
			if (target.startsWith(word)) {
				count += solveByRecursion(target.substring(word.length()), wordBank, memo);
			}
		}
		
		memo.put(target, count);
		return count;
	}
}
