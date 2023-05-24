package br.com.dbarreto.challenge.hackerrank.interview.kit.greedy.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.dbarreto.challenge.hackerrank.interview.kit.greedy.ReverseShuffleMerge;

public class TestReverseShuffleMerge {
	
	private ReverseShuffleMerge solution = new ReverseShuffleMerge();
	
	@Test
	public void testCase001() {
		assertEquals("egg", solution.reverseShuffleMerge("eggegg"));
	}
	
	@Test
	public void testCase002() {
		assertEquals("agfedcb", solution.reverseShuffleMerge("abcdefgabcdefg"));
	}
	
	@Test
	public void testCase003() {
		assertEquals("aeiou", solution.reverseShuffleMerge("aeiouuoiea"));
	}
}
