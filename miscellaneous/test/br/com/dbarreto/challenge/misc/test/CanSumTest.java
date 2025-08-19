package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.CanSum;

public class CanSumTest {

	private CanSum problem = new CanSum();
	
	@Test
	public void testCase001() {
		
		assertTrue(problem.solveByRecursion(7, Arrays.asList(2, 3)));
		assertTrue(problem.solveByRecursion(7, Arrays.asList(5, 3, 4, 7)));
		assertFalse(problem.solveByRecursion(7, Arrays.asList(2, 4)));
		assertTrue(problem.solveByRecursion(8, Arrays.asList(2, 3, 5)));
		assertFalse(problem.solveByRecursion(300, Arrays.asList(7, 14)));
	}
}
