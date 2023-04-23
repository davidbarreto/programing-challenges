package br.com.dbarreto.challenge.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Return a boolean indicating whether or not it
 * is possible to generate the 'targetSum' using numbers
 * form the array. You may use an element of the array as
 * many times as needed. You assume that all input numbers are
 * nonnegative. 
 *
 */
public class CanSum {
	
	public boolean solveByRecursion(int targetSum, List<Integer> array) {
		return solveByRecursion(targetSum, array, new HashMap<>());
	}

	public boolean solveByRecursion(int targetSum, List<Integer> array, Map<Integer, Boolean> memo) {

		if (memo.containsKey(targetSum)) {
			return memo.get(targetSum);
		}
		
		if (targetSum < 0) {
			return false;
		}
		
		if (targetSum == 0) {
			return true;
		}
		
		for (int value : array) {
			if (solveByRecursion(targetSum - value, array, memo)) {
				memo.put(targetSum, true);
				return true;
			}
		}
		
		memo.put(targetSum, false);
		return false;
	}
}
