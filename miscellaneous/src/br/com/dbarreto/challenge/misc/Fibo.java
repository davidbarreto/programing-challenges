package br.com.dbarreto.challenge.misc;

import java.util.HashMap;
import java.util.Map;

public class Fibo {

	public long fibo(int n) {
		return fibo(n, new HashMap<>());
	}
	
	private long fibo(int n, Map<Integer, Long> mem) {
		if (mem.containsKey(n)) {
			return mem.get(n);
		}
		
		if (n <= 2) {
			return 1L;
		}
		
		long ans = fibo(n-1, mem) + fibo(n-2, mem);
		mem.put(n, ans);
		return ans;
	}
}
