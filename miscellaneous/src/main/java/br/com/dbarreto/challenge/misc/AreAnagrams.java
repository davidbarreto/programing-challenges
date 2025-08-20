package br.com.dbarreto.challenge.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AreAnagrams {

	public boolean solveUsingHash(String s1, String s2) {
		
		if (s1 == null && s2 == null) {
			return true;
		}
		
		if (s1 == null || s2 == null) {
			return false;
		}
		
		if (s1.length() != s2.length()) {
			return false;
		}
		
		Map<Integer, Integer> freqs = new HashMap<>();
		addFreq(s1, freqs);
		decreaseFreq(s2, freqs);
		
		return freqs.values().stream().filter(a -> a != 0).count() == 0;
	}
	
	private void addFreq(String s, Map<Integer, Integer> freqs) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freqs.merge((int)c, 1, Integer::sum);
		}
	}
	
	private void decreaseFreq(String s, Map<Integer, Integer> freqs) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freqs.merge((int)c, 0, (a, b) -> a - 1);
		}
	}
	
	/**
	 * Time: O(n)
	 * Space O(k)
	 * n = length of s1
	 * m = length of s2
	 * k = length of the set of possible chars
	 * It's bad if there are a large set of possible characters
	 */
	public boolean solveUsingArray(String s1, String s2) {
		
		if (s1 == null && s2 == null) {
			return true;
		}
		
		if (s1 == null || s2 == null) {
			return false;
		}
		
		if (s1.length() != s2.length()) {
			return false;
		}
		
		short[] freq1 = new short[26];
		short[] freq2 = new short[26];
		
		updateFreq(s1, freq1);
		updateFreq(s2, freq2);
		
		return Arrays.compare(freq1, freq2) == 0;
	}
	
	private void updateFreq(String s, short[] freq) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freq[c - 'a']++;
		}
	}
}
