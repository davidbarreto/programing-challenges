package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class AllConstructTest {

	private AllConstruct problem = new AllConstruct();
	
	@Test
	public void testCase001() {
		List<List<String>> ans = Arrays.asList(Arrays.asList("ef", "cd", "ab"), Arrays.asList("def", "c", "ab"), Arrays.asList("def", "abc"), Arrays.asList("ef", "abcd"));
		assertEquals(ans, problem.solveByRecursion("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
	}
}
