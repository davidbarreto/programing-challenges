package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.BestSum;

public class TestBestSum {

	private BestSum problem = new BestSum();
	
	@Test
	public void testCase001() {
		assertEquals(Arrays.asList(7), problem.solveByRecursion(7, Arrays.asList(5, 3, 4, 7)));
	}
	
	@Test
	public void testCase002() {
		assertEquals(Arrays.asList(3, 5), problem.solveByRecursion(8, Arrays.asList(2, 3, 5)).stream().sorted().collect(Collectors.toList()));
	}
	
	@Test
	public void testCase003() {
		assertEquals(Arrays.asList(4, 4), problem.solveByRecursion(8, Arrays.asList(1, 4, 5)));
	}
	
	@Test
	public void testCase004() {
		assertEquals(Arrays.asList(25, 25, 25, 25), problem.solveByRecursion(100, Arrays.asList(1, 2, 5, 25)));
	}
}
