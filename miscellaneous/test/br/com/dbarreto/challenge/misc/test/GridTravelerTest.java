package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.GridTraveler;

public class GridTravelerTest {

	private GridTraveler problem = new GridTraveler();
	
	@Test
	public void testCase001() {
		assertEquals(1, problem.solveByRecursion(1, 1));
		assertEquals(3, problem.solveByRecursion(2, 3));
		assertEquals(3, problem.solveByRecursion(3, 2));
		assertEquals(2333606220L, problem.solveByRecursion(18, 18));
	}
}
