package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.AreAnagrams;

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
