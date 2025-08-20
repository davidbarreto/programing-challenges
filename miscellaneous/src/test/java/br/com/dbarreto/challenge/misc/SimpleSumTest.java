package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SimpleSumTest {

	@Test
	public void testCase001() {
		SimpleSum problem = new SimpleSum();
		assertEquals(20, problem.sum(List.of(5, -2, 3, 14)));
		assertEquals(20, problem.sum(List.of(5, -2, 3, 14), 0));
	}
}
