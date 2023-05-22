package br.com.dbarreto.challenge.misc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.FindSumOfTwoNumbers;

public class TestFindSumOfTwoNumbers {
	
	@Test
	public void testCase001() {
		FindSumOfTwoNumbers problem = new FindSumOfTwoNumbers();
		
		int target = 12;
		List<Integer> input = List.of(1,3,5,7,9);
		
		List<Integer> res = problem.solveSorted(input, target);
		assertEquals(target, res.get(0) + res.get(1));
		assertTrue(input.contains(res.get(0)));
		assertTrue(input.contains(res.get(1)));
	}
	
	@Test
	public void testCase002() {
		FindSumOfTwoNumbers problem = new FindSumOfTwoNumbers();
		
		int target = 12;
		List<Integer> input = List.of(1,3,5,7,9);
		
		List<Integer> res = problem.solveUnsorted(input, target);
		assertEquals(target, res.get(0) + res.get(1));
		assertTrue(input.contains(res.get(0)));
		assertTrue(input.contains(res.get(1)));
	}
	
	@Test
	public void testCase003() {
		FindSumOfTwoNumbers problem = new FindSumOfTwoNumbers();
		
		int target = 12;
		List<Integer> input = List.of(5,2,9,7,3,1,8);
		
		List<Integer> res = problem.solveUnsorted(input, target);
		assertEquals(target, res.get(0) + res.get(1));
		assertTrue(input.contains(res.get(0)));
		assertTrue(input.contains(res.get(1)));
	}

}
