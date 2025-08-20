package br.com.dbarreto.challenge.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Return an array containing the shortest
 * combination of numbers that add up to exactly
 * the 'targetSum'. If there is a tie for the shortest
 * combination, you may return any one of the shortest 
 */
public class BestSum {

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
		
		List<Integer> minAns = null;
		for (int value : array) {
			List<Integer> ans = solveByRecursion(targetSum - value, array, memo);
			
			if (ans != null) {
				List<Integer> combination = new ArrayList<>();
				combination.addAll(ans);
				combination.add(value);
				
				if (minAns == null || combination.size() < minAns.size()) {
					minAns = combination;
				}
			}
		}

		memo.put(targetSum, minAns);
		return minAns;
	}
}
