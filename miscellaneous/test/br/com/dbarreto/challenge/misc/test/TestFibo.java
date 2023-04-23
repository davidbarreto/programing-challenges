package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.Fibo;

public class TestFibo {

	private Fibo problem = new Fibo();
	
	@Test
	public void testCase001() {
		assertEquals(1, problem.fibo(1));
	}
	
	@Test
	public void testCase002() {
		assertEquals(1, problem.fibo(2));
	}
	
	@Test
	public void testCase003() {
		assertEquals(13, problem.fibo(7));
	}
	
	@Test
	public void testCase004() {
		assertEquals(21, problem.fibo(8));
	}
	
	@Test
	public void testCase005() {
		assertEquals(12586269025L, problem.fibo(50));
	}
}
