package br.com.dbarreto.challenge.codility.interview.real;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class BikeRacksTest {
	
	private BikeRacks br = new BikeRacks();
	
	@Test
	public void testCase001() {
		int[] input = {5};
		assertEquals(0, br.solution(input));
	}
	
	@Test
	public void testCase002() {
		int[] input = {5,5};
		assertEquals(0, br.solution(input));
	}
	
	@Test
	public void testCase003() {
		int[] input = {10,0,8,2,-1,12,11,3};
		assertEquals(2, br.solution(input));
	}
	
	@Test
	public void testCase004() {
		int[] input = {-1_000_000_000,1_000_000_000};
		assertEquals(1_000_000_000, br.solution(input));
	}
	
	@Test
	public void testCase005() {
		int[] input = {1_000_000_000,-1_000_000_000};
		assertEquals(1_000_000_000, br.solution(input));
	}
	
	@Test
	public void testCase006() {
		int[] input = new int[100_000];
		input[0] = -1_000_000_000;
		for (int i = 1; i < 100_000; i++) {
			input[i] = input[i-1] + 5;
		}
		
		assertEquals(2, br.solution(input));
	}
	
	@Test
	public void testCase007() {
		int[] input = new int[100_000];
		for (int i = 0; i < 100_000; i++) {
			input[i] = -1_000_000_000;
		}
		
		assertEquals(0, br.solution(input));
	}
}
