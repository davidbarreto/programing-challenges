package br.com.dbarreto.challenge.hackerrank.interview.real.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.dbarreto.challenge.hackerrank.interview.real.RiverRecords;

public class TestRiverRecords {
	
	private RiverRecords solution = new RiverRecords();
	
	@Test
	public void testCase001() {
		assertEquals(-1, solution.maximumTrailing(List.of(4, 3, 2, 1)));
	}
	
	@Test
	public void testCase002() {
		assertEquals(4, solution.maximumTrailing(List.of(5, 3, 6, 7, 4)));
	}
	
	@Test
	public void testCase003() {
		assertEquals(4, solution.maximumTrailing(List.of(-5, -4, -3, -2, -1)));
	}
	
	@Test
	public void testCase004() {
		assertEquals(-1, solution.maximumTrailing(List.of(-1, -2, -3, -4, -5)));
	}
	
	@Test
	public void testCase005() {
		assertEquals(13, solution.maximumTrailing(List.of(5, 2, 12, 15, 11)));
	}
	
	@Test
	public void testCase006() {
		assertEquals(-1, solution.maximumTrailing(List.of(5)));
	}
	
	@Test
	public void testCase007() {
		assertEquals(2, solution.maximumTrailing(List.of(9, 8, 7, 8, 9)));
	}
	
	@Test
	public void testCase008() {
		assertEquals(3, solution.maximumTrailing(List.of(-3, -2, -1, 0, -5)));
	}
	
	@Test
	public void testCase009() {
		assertEquals(2000000, solution.maximumTrailing(List.of(-1, -1000000, 0, 1000000, 15)));
	}
	
	@Test
	public void testCase010() {
		assertEquals(0, solution.maximumTrailing(List.of(1000000, 1000000, 1000000, 1000000, 1000000)));
	}
	
	@Test
	public void testCase011() {
		
		List<Integer> input = new ArrayList<>(); 
		for (int i = 0; i < 200000; i++) {
			input.add(200000-i);
		}
		assertEquals(-1, solution.maximumTrailing(input));
	}
	
	@Test
	public void testCase012() {
		
		List<Integer> input = new ArrayList<>(); 
		for (int i = 0; i < 200000; i++) {
			input.add(i+1);
		}
		assertEquals(199999, solution.maximumTrailing(input));
	}
	
	@Test
	public void testCase013() {
		assertEquals(0, solution.maximumTrailing(List.of(1000000, 1000000, 1000000, 1000000, 1000000)));
	}
	
	@Test
	public void testCase014() {
		assertEquals(-1, solution.maximumTrailing(List.of(1000000, 1)));
	}
	
	@Test
	public void testCase015() {
		assertEquals(999999, solution.maximumTrailing(List.of(1, 1000000)));
	}
}
