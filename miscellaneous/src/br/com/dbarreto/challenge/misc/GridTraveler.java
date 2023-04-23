package br.com.dbarreto.challenge.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Say that you are a traveler on a 2D grid. You begin in the
 * top-left corner and your goal is to travel to the bottom-right corner. 
 * You may only move down or right.
 * In how many ways can you travel to the goal on a grid with dimensions m*n
 */
public class GridTraveler {

	public long solveByRecursion(int m, int n) {
		return solveByRecursion(m, n, new HashMap<>());
	}
	
	public long solveByRecursion(int m, int n, Map<String, Long> memo) {
		
		String key = m > n ? (m + ";" + n) : (n + ";" + m);
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		
		if (m == 0 || n == 0) {
			return 0L;
		}
		
		if (m == 1 && n == 1) {
			return 1L;
		}
		
		long ans = solveByRecursion(m-1, n, memo) + solveByRecursion(m, n-1, memo);
		memo.put(key, ans);
		return ans;
	}
}
