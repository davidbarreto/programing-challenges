package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.CountConstruct;

public class TestCountConstruct {

	private CountConstruct problem = new CountConstruct();
	
	@Test
	public void testCase001() {
		assertEquals(2, problem.solveByRecursion("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
	}
	
	@Test
	public void testCase002() {
		assertEquals(1, problem.solveByRecursion("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
	}
	
	@Test
	public void testCase003() {
		assertEquals(0, problem.solveByRecursion("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
	}
	
	@Test
	public void testCase004() {
		assertEquals(4, problem.solveByRecursion("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
	}
	
	@Test
	public void testCase005() {
		assertEquals(0, problem.solveByRecursion("purple", Arrays.asList("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", "e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
	}
}
