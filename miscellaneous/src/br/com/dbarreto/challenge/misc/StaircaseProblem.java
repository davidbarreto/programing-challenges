package br.com.dbarreto.challenge.misc;

import java.util.HashMap;
import java.util.Map;

public class StaircaseProblem {

	public int numWays(int n) {
		return numWays(n, new HashMap<>());
	}
	
	public int numWays(int n, Map<Integer, Integer> memo) {
		
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		
		if (n < 0) {
			return 0;
		}
		
		if (n == 0 || n == 1) {
			return 1;
		}
		
		int ans = numWays(n-1, memo) + numWays(n-2, memo);
		memo.put(n, ans);
		return ans;
	}
	
	public int numWays(int n, int[] steps) {
		return numWays(n, steps, new HashMap<>());
	}
	
	public int numWays(int n, int[] steps, Map<Integer, Integer> memo) {
		
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		
		if (n < 0) {
			return 0;
		}
		
		if (n == 0 || n == 1) {
			return 1;
		}
		
		int count = 0;
		for (int step : steps) {
			count += numWays(n-step, steps, memo);
		}
		
		memo.put(n, count);
		return count;
	}
}
