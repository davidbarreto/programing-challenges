package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.RemovingIslands;

public class RemovingIslandsTest {
	
	private RemovingIslands problem = new RemovingIslands();

	@Test
	public void testCase001() {

		int[][] input = { { 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 1 }, { 0, 0, 1, 0, 1, 0 }, { 1, 1, 0, 0, 1, 0 },
				{ 1, 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 1 } };
		
		int[][] expected = { { 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 1, 0 }, { 1, 1, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 1 } };
		
		
		int[][] ans = problem.remove(input);
		assertArrayEquals(expected, ans);
	}
}
