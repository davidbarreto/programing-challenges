package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.AllConstruct;

public class TestAllConstruct {

	private AllConstruct problem = new AllConstruct();
	
	@Test
	public void testCase001() {
		List<List<String>> ans = Arrays.asList(Arrays.asList("ef", "cd", "ab"), Arrays.asList("def", "c", "ab"), Arrays.asList("def", "abc"), Arrays.asList("ef", "abcd"));
		assertEquals(ans, problem.solveByRecursion("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
	}
}
