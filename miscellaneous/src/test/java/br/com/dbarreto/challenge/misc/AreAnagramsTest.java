package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreAnagramsTest {
	
	private AreAnagrams problem = new AreAnagrams();

	@Test
	public void testHashSolutionAnagram() {
		assertTrue(problem.solveUsingHash("maca", "cama"));
	}
	
	@Test
	public void testHashSolutionNotAnagram() {
		assertFalse(problem.solveUsingHash("maca", "abcd"));
	}
	
	@Test
	public void testArraySolutionAnagram() {
		assertTrue(problem.solveUsingArray("maca", "cama"));
	}
	
	@Test
	public void testArraySolutionNotAnagram() {
		assertFalse(problem.solveUsingArray("maca", "abcd"));
	}
}
