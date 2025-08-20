package br.com.dbarreto.challenge.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Return a boolean indicating whether or not the 'target'
 * can be constructed by concatenating elements from the 'wordBank' array
 * You may reuse elements of 'wordBank' as many times as needed
 */
public class CanConstruct {

	public boolean solveByRecursion(String target, List<String> wordBank) {
		return solveByRecorsion(target, wordBank, new HashMap<>());
	}
	
	public boolean solveByRecorsion(String target, List<String> wordBank, Map<String, Boolean> memo) {

		if (memo.containsKey(target)) {
			return memo.get(target);
		}
		
		if (target.isEmpty()) {
			return true;
		}
		
		for (String word : wordBank) {
			
			if (target.startsWith(word) && solveByRecorsion(target.substring(word.length()), wordBank, memo)) {
					memo.put(target, true);
					return true;
			}
		}
		
		memo.put(target, false);
		return false;
	}
}
