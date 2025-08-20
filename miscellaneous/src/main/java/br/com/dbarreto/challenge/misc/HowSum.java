package br.com.dbarreto.challenge.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Return an array containing any combination of elements of the 'array'
 * that add up to exactly the 'targetSum'. If there is no
 * combination that adds up to the 'targetSum', then return null 
 */
public class HowSum {
	
	public List<Integer> solveByRecursion(int targetSum, List<Integer> array) {
		return solveByRecursion(targetSum, array, new HashMap<>());
	}

	public List<Integer> solveByRecursion(int targetSum, List<Integer> array, Map<Integer, List<Integer>> memo) {

		if (memo.containsKey(targetSum)) {
			return memo.get(targetSum);
		}
		
		if (targetSum < 0) {
			return null;
		}
		
		if (targetSum == 0) {
			return new ArrayList<>();
		}
		
		for (int value : array) {
			List<Integer> ans = solveByRecursion(targetSum - value, array, memo);
			if (ans != null) {
				ans.add(value);
				memo.put(targetSum, ans);
				return ans;
			}
		}
		
		memo.put(targetSum, null);
		return null;
	}
}
