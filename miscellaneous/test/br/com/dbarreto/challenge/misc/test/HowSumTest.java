package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.HowSum;

public class HowSumTest {

	private HowSum problem = new HowSum();
	
	@Test
	public void testCase001() {
		
		int targetSum = 0;
		List<Integer> arr = null;
		List<Integer> ans = null;

		targetSum = 7;
		arr = Arrays.asList(2, 3);
		assertAnswer(targetSum, arr);
		
		targetSum = 7;
		arr = Arrays.asList(5, 3, 4, 7);
		assertAnswer(targetSum, arr);
		
		targetSum = 7;
		arr = Arrays.asList(2, 4);
		ans = problem.solveByRecursion(targetSum, arr);
		assertNull(ans);
		
		targetSum = 8;
		arr = Arrays.asList(2, 3, 5);
		assertAnswer(targetSum, arr);
		
		targetSum = 300;
		arr = Arrays.asList(7, 14);
		ans = problem.solveByRecursion(targetSum, arr);
		assertNull(ans);
	}
	
	private void assertAnswer(int targetSum, List<Integer> arr) {
		List<Integer> ans = problem.solveByRecursion(targetSum, arr);
		assertEquals(targetSum, ans.stream().mapToInt(Integer::intValue).sum());
		assertTrue(arr.containsAll(ans));
	}
}
