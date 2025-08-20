package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class CanConstructTest {

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
