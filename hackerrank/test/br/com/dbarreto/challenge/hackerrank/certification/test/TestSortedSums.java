package br.com.dbarreto.challenge.hackerrank.certification.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import br.com.dbarreto.challenge.hackerrank.certification.SortedSums;

public class TestSortedSums {

	private SortedSums problem = new SortedSums();

	@Test
	public void testCase001() {

		assertEquals(364271696, problem.sortedSum(Arrays.asList(747402, 380408, 605449, 846906, 385224, 31431, 677517,
				770001, 389085, 40373, 487560, 886252, 596334, 59083)));
	}

	@Test
	public void testCase002() {
		assertEquals(145945368, problem
				.sortedSum(Arrays.asList(726610, 5429, 998092, 203911, 48773, 897342, 163057, 930001, 83522, 945114)));
	}
}
