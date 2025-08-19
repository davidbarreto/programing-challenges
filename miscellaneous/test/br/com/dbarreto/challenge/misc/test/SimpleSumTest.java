package br.com.dbarreto.challenge.misc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.SimpleSum;

public class TestSimpleSum {

	@Test
	public void testCase001() {
		SimpleSum problem = new SimpleSum();
		assertEquals(20, problem.sum(List.of(5, -2, 3, 14)));
		assertEquals(20, problem.sum(List.of(5, -2, 3, 14), 0));
	}
}
