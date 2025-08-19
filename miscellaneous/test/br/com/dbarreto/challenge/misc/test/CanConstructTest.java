package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.CanConstruct;

public class TestCanConstruct {

	private CanConstruct problem = new CanConstruct();
	
	@Test
	public void testCase001() {
		assertTrue(problem.solveByRecursion("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
	}
	
	@Test
	public void testCase002() {
		assertFalse(problem.solveByRecursion("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
	}
	
	@Test
	public void testCase003() {
		assertTrue(problem.solveByRecursion("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
	}
	
	@Test
	public void testCase004() {
		assertFalse(problem.solveByRecursion("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
	}
}
