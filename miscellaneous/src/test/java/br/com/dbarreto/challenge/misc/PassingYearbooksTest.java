package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
