package br.com.dbarreto.challenge.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Return a list of all options on 'wordBank' that we can used to construct
 * 'target' by concatenating them.
 * You may reuse elements of 'wordBank' as many times as needed
 */
public class AllConstruct {

	public List<List<String>> solveByRecursion(String target, List<String> wordBank) {
		return solveByRecursion(target, wordBank, new HashMap<>());
	}
	
	public List<List<String>> solveByRecursion(String target, List<String> wordBank, Map<String, List<List<String>>> memo) {
		
		if (memo.containsKey(target)) {
			return memo.get(target);
		}
		
		if (target.isEmpty()) {
			List<List<String>> ret = new ArrayList<>();
			ret.add(new ArrayList<>());
			return ret;
		}
		
		List<List<String>> result = new ArrayList<>();
		for (String word : wordBank) {
			if (target.startsWith(word)) {
				List<List<String>> ans = solveByRecursion(target.substring(word.length()), wordBank, memo);
				for (List<String> list : ans) {
					list.add(word);
				}
				result.addAll(ans);
			}
			
		}
		
		return result;
	}
}
