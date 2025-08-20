package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StaircaseProblemTest {

	private StaircaseProblem problem = new StaircaseProblem();
	
	@Test
	public void testCase001() {
		assertEquals(0, problem.numWays(-1));
	}
	
	@Test
	public void testCase002() {
		assertEquals(1, problem.numWays(0));
	}
	
	@Test
	public void testCase003() {
		assertEquals(1, problem.numWays(1));
	}
	
	@Test
	public void testCase004() {
		assertEquals(2, problem.numWays(2));
	}
	
	@Test
	public void testCase005() {
		assertEquals(5, problem.numWays(4));
	}
	
	@Test
	public void testCase006() {
		int[] steps = {1, 3, 5};
		assertEquals(3, problem.numWays(4, steps));
	}
}
