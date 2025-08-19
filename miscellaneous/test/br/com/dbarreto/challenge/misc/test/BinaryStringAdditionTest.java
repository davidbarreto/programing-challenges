package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.BinaryStringAddition;

public class BinaryStringAdditionTest {

	private BinaryStringAddition problem = new BinaryStringAddition();
	
	@Test
	public void testCase001() {
		assertEquals("1", problem.add("1", "0"));
	}
	
	@Test
	public void testCase002() {
		assertEquals("10", problem.add("1", "1"));
	}
	
	@Test
	public void testCase003() {
		assertEquals("11", problem.add("10", "1"));
	}
	
	@Test
	public void testCase004() {
		assertEquals("100", problem.add("10", "10"));
	}
	
	@Test
	public void testCase005() {
		assertEquals("1000", problem.add("111", "1"));
	}
	
	@Test
	public void testCase006() {
		assertEquals("1000", problem.add("1", "111"));
	}
}
