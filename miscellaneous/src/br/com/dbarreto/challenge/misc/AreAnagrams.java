package br.com.dbarreto.challenge.misc;

import java.util.Arrays;

public class AreAnagrams {

	public boolean solveUsingHash(String s1, String s2) {
		
		
		return false;
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
