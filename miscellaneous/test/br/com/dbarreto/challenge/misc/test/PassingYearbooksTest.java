package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.PassingYearbooks;

public class PassingYearbooksTest {

	private PassingYearbooks problem = new PassingYearbooks();
	
	@Test
	public void testCase001() {
		int[] arr = {2, 1};
	    int[] expected = {2, 2};
	    assertArrayEquals(expected, problem.findSignatureCounts(arr));
	}
	
	@Test
	public void testCase002() {
		int[] arr = {1, 2};
	    int[] expected = {1, 1};
		assertArrayEquals(expected, problem.findSignatureCounts(arr));
	}
}
